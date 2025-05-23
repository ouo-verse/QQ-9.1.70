package com.tencent.oskplayer.datasource;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.datasource.HttpDataSource;
import com.tencent.oskplayer.proxy.HttpRetryLogic;
import com.tencent.oskplayer.proxy.UuidPlayIdMap;
import com.tencent.oskplayer.proxy.VideoRequest;
import com.tencent.oskplayer.util.Fixer;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.oskplayer.util.Predicate;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class NiceHttpDataSource extends DefaultHttpDataSource {
    private static boolean configLoaded = false;
    private static int sMaxRetryCount = 3;
    private HttpRetryLogic httpRetryLogic;
    private VideoRequest mVideoRequest;
    private int readRetryCount;
    private String uuid;

    public NiceHttpDataSource(String str, Predicate<String> predicate, TransferListener transferListener, HttpRetryLogic httpRetryLogic, Fixer<Map<String, List<String>>> fixer, VideoRequest videoRequest) {
        super(str, predicate, transferListener, 30000, 12000, true, fixer);
        this.readRetryCount = 0;
        this.httpRetryLogic = httpRetryLogic;
        this.mVideoRequest = videoRequest;
        this.TAG = "NiceHttpDataSource";
        if (!configLoaded) {
            sMaxRetryCount = PlayerConfig.g().getDataSourceMaxRetryCount();
            configLoaded = true;
        }
        HttpHeader globalExtraHeader = PlayerConfig.g().getGlobalExtraHeader();
        if (globalExtraHeader != null) {
            for (Map.Entry<String, String> entry : globalExtraHeader.getSnapshot().entrySet()) {
                setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        HttpHeader extraHeader = videoRequest.getExtraHeader();
        if (extraHeader != null) {
            for (Map.Entry<String, String> entry2 : extraHeader.getSnapshot().entrySet()) {
                setRequestProperty(entry2.getKey(), entry2.getValue());
            }
        }
    }

    private int readRetry(byte[] bArr, int i3, int i16, HttpDataSource.HttpDataSourceException httpDataSourceException) throws HttpDataSource.HttpDataSourceException {
        if (!UuidPlayIdMap.isUuidDeleted(getDataSpec().uuid)) {
            PlayerUtils.log(4, getLogTag(), "read source error occurred " + httpDataSourceException.toString());
            this.readRetryCount = this.readRetryCount + 1;
            long bytesRead = getDataSpec().position + bytesRead();
            int i17 = this.readRetryCount * 2000;
            PlayerUtils.log(4, getLogTag(), "retrying after " + i17 + " seconds, read start at offset " + bytesRead + " retry " + this.readRetryCount + "/" + sMaxRetryCount);
            try {
                LockMethodProxy.sleep(i17);
                DataSpec dataSpec = new DataSpec(Uri.parse(getUri()), 0L, bytesRead, -1L, (String) null, 0, this.uuid, getDataSpec().priority);
                if (!Thread.currentThread().isInterrupted()) {
                    if (this.readRetryCount < sMaxRetryCount) {
                        if (!this.mVideoRequest.shouldCancel()) {
                            open(dataSpec);
                            return read(bArr, i3, i16);
                        }
                        PlayerUtils.log(4, getLogTag(), "abort retry videoRequest is cancelling " + this.mVideoRequest);
                        throw new HttpDataSource.InterruptReadException("readRetry interrupted " + this.mVideoRequest, getDataSpec());
                    }
                    throw httpDataSourceException;
                }
                throw httpDataSourceException;
            } catch (InterruptedException unused) {
                PlayerUtils.log(5, getLogTag(), "readRetry interrupted");
                throw httpDataSourceException;
            }
        }
        throw new HttpDataSource.InterruptReadException("readRetry interrupted UuidDeleted" + this.mVideoRequest, getDataSpec());
    }

    private long retryOpen(DataSpec dataSpec, String str, HttpDataSource.HttpDataSourceException httpDataSourceException) throws HttpDataSource.HttpDataSourceException {
        Map<String, List<String>> map;
        int i3;
        DataSpec dataSpec2 = dataSpec;
        int i16 = 0;
        if (httpDataSourceException instanceof HttpDataSource.InvalidResponseCodeException) {
            HttpDataSource.InvalidResponseCodeException invalidResponseCodeException = (HttpDataSource.InvalidResponseCodeException) httpDataSourceException;
            i3 = invalidResponseCodeException.responseCode;
            map = invalidResponseCodeException.headerFields;
        } else {
            map = null;
            i3 = 0;
        }
        String uri = dataSpec2.uri.toString();
        int i17 = 4;
        PlayerUtils.log(4, getLogTag(), "retryOpen url=" + uri + " with responseCode=" + i3);
        while (!Thread.currentThread().isInterrupted()) {
            if (i16 < sMaxRetryCount) {
                HttpRetryLogic httpRetryLogic = this.httpRetryLogic;
                if (httpRetryLogic != null) {
                    String retryUrl = httpRetryLogic.getRetryUrl(uri, i16, i3, map);
                    PlayerUtils.log(i17, getLogTag(), "retryCount=" + i16 + " retryUrl=" + retryUrl);
                    if (TextUtils.isEmpty(retryUrl)) {
                        retryUrl = uri;
                    } else if (retryUrl.equals(uri)) {
                        PlayerUtils.log(5, getLogTag(), "retryUrl is same as origin url");
                    }
                    if (!UuidPlayIdMap.isUuidDeleted(dataSpec2.uuid)) {
                        int i18 = i16 + 1;
                        int i19 = i18 * 2000;
                        PlayerUtils.log(i17, getLogTag(), "retry open retrying after " + i19 + " seconds  retry " + i18 + "/" + sMaxRetryCount);
                        try {
                            LockMethodProxy.sleep(i19);
                            try {
                                return super.open(new DataSpec(Uri.parse(retryUrl), dataSpec2.absoluteStreamPosition, dataSpec2.position, dataSpec2.length, dataSpec2.key, dataSpec2.flags, dataSpec2.uuid, dataSpec2.priority), str);
                            } catch (HttpDataSource.HttpDataSourceException e16) {
                                if (this.mVideoRequest != null && this.mVideoRequest.shouldCancel()) {
                                    PlayerUtils.log(4, getLogTag(), "abort retryOpen videoRequest is cancelling " + this.mVideoRequest + ",reason=" + PlayerUtils.getPrintableStackTrace(e16));
                                    throw new HttpDataSource.InterruptConnectServerException("retry open interrupted " + this.mVideoRequest, getDataSpec());
                                }
                                uri = retryUrl;
                                i16 = i18;
                                i17 = 4;
                            }
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            throw new HttpDataSource.InterruptConnectServerException("retry open  interrupted " + this.mVideoRequest, getDataSpec());
                        }
                    } else {
                        throw new HttpDataSource.InterruptConnectServerException("retry open interrupted UuidDeleted" + this.mVideoRequest, getDataSpec());
                    }
                } else {
                    PlayerUtils.log(4, getLogTag(), "httpRetryLogic is null");
                    throw httpDataSourceException;
                }
            } else {
                throw httpDataSourceException;
            }
        }
        throw httpDataSourceException;
    }

    @Override // com.tencent.oskplayer.datasource.DefaultHttpDataSource, com.tencent.oskplayer.datasource.HttpDataSource, com.tencent.oskplayer.datasource.DataSource
    public long open(DataSpec dataSpec) throws HttpDataSource.HttpDataSourceException {
        this.uuid = dataSpec.uuid;
        try {
            return super.open(dataSpec);
        } catch (HttpDataSource.HttpDataSourceException e16) {
            return retryOpen(dataSpec, null, e16);
        }
    }

    @Override // com.tencent.oskplayer.datasource.DefaultHttpDataSource, com.tencent.oskplayer.datasource.HttpDataSource, com.tencent.oskplayer.datasource.DataSource
    public int read(byte[] bArr, int i3, int i16) throws HttpDataSource.HttpDataSourceException {
        try {
            return super.read(bArr, i3, i16);
        } catch (HttpDataSource.HttpDataSourceException e16) {
            return readRetry(bArr, i3, i16, e16);
        }
    }
}
