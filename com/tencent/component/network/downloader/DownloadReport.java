package com.tencent.component.network.downloader;

import java.util.List;
import okhttp3.Response;
import org.apache.http.HttpResponse;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class DownloadReport {
    public String clientip;
    public int concurrent;
    public String content_type;
    public int currAttempCount;
    public String dns;
    public String domain;
    public int downloadMode;
    public long downloadTime;
    public long endTime;
    public Throwable exception;
    public long fileSize;
    public int httpStatus;

    /* renamed from: id, reason: collision with root package name */
    public int f99895id;
    public boolean isFromQzoneAlbum;
    public boolean isHttp2;
    public boolean isHttps;
    public boolean isSucceed = false;
    public String localAddress;
    public String logInfo;
    public Response okResponse;

    /* renamed from: protocol, reason: collision with root package name */
    public String f99896protocol;
    public List<RangeDownloadReport> rangeDownloadReports;
    public int rangeNumber;
    public String refer;
    public String remoteAddress;
    public HttpResponse response;
    public long startTime;
    public int strategyId;
    public String strategyInfo;
    public long t_conn;
    public long t_prepare;
    public long t_process;
    public long t_recvdata;
    public long t_recvrsp;
    public long t_wait;
    public long timeCostForRangeMergePhase;
    public long timeCostForRangeReceivePhase;
    public long totaltime;
    public String url;
}
