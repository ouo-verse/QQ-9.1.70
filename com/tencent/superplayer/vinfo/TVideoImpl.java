package com.tencent.superplayer.vinfo;

import android.content.Context;
import android.os.Looper;
import com.tencent.qqlive.superplayer.player.TVKMediaSource;
import com.tencent.qqlive.superplayer.vinfo.TVKLiveVideoInfo;
import com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.superplayer.vinfo.TVKPlayerVideoInfo;
import com.tencent.qqlive.superplayer.vinfo.TVKPlayerWrapperCGIModel;
import com.tencent.qqlive.superplayer.vinfo.TVKUserInfo;
import com.tencent.qqlive.superplayer.vinfo.TVKVideoInfo;
import com.tencent.qqlive.superplayer.vinfo.b;
import com.tencent.qqlive.superplayer.vinfo.c;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.api.TVideoNetInfo;
import com.tencent.superplayer.player.ErrorCode;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.vinfo.VInfoGetter;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes26.dex */
public class TVideoImpl {
    public static final String TAG = "TVideoImpl";
    private Context mContext;
    private VInfoGetter.VInfoGetterListener mListener;
    private TVKPlayerWrapperCGIModel mWrapperCGI;
    private TVKPlayerCGICallback mWrapperCGICallback = new TVKPlayerCGICallback();

    /* compiled from: P */
    /* loaded from: classes26.dex */
    private class TVKPlayerCGICallback implements TVKPlayerWrapperCGIModel.d {
        TVKPlayerCGICallback() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.TVKPlayerWrapperCGIModel.d
        public void onGetLiveInfoFailed(int i3, b.c cVar, TVKLiveVideoInfo tVKLiveVideoInfo) {
            if (TVideoImpl.this.mListener != null) {
                TVideoImpl.this.mListener.onGetVInfoFailed((SuperPlayerVideoInfo) cVar.r(), 5002, ErrorCode.ERROR_CODE_TVIDEO_LIVE_INFO_ERROR, tVKLiveVideoInfo.getErrInfo());
            }
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.TVKPlayerWrapperCGIModel.d
        public void onGetLiveInfoSuccess(int i3, b.c cVar, TVKLiveVideoInfo tVKLiveVideoInfo) {
            int i16;
            if (tVKLiveVideoInfo == null) {
                LogUtil.e(TVideoImpl.TAG, "onGetLiveInfoSuccess() reqType " + i3 + ", liveInfo == null");
                return;
            }
            SuperPlayerVideoInfo superPlayerVideoInfo = (SuperPlayerVideoInfo) cVar.r();
            boolean z16 = true;
            if (tVKLiveVideoInfo.getStream() == 2) {
                i16 = 401;
            } else if (tVKLiveVideoInfo.getStream() == 1) {
                i16 = 402;
            } else {
                i16 = 403;
            }
            superPlayerVideoInfo.setPlayUrl(tVKLiveVideoInfo.getPlayUrl());
            superPlayerVideoInfo.setFormat(i16);
            TVideoNetInfo tVideoNetInfo = new TVideoNetInfo();
            ArrayList<TVideoNetInfo.DefinitionInfo> arrayList = new ArrayList<>();
            if (tVKLiveVideoInfo.getDefinitionList() != null) {
                Iterator<TVKNetVideoInfo.DefnInfo> it = tVKLiveVideoInfo.getDefinitionList().iterator();
                while (it.hasNext()) {
                    TVKNetVideoInfo.DefnInfo next = it.next();
                    arrayList.add(new TVideoNetInfo.DefinitionInfo(next.getDefn(), next.getDefnName(), next.getDefnRate(), next.getDefnShowName()));
                }
            } else {
                LogUtil.e(TVideoImpl.TAG, "onGetLiveInfoSuccess() reqType:" + i3 + "  liveInfo.getDefinitionList() == null");
            }
            tVideoNetInfo.setDefinitionList(arrayList);
            if (tVKLiveVideoInfo.getCurDefinition() != null) {
                tVideoNetInfo.setCurrentDefinition(new TVideoNetInfo.DefinitionInfo(tVKLiveVideoInfo.getCurDefinition().getDefn(), tVKLiveVideoInfo.getCurDefinition().getDefnName(), tVKLiveVideoInfo.getCurDefinition().getDefnRate(), tVKLiveVideoInfo.getCurDefinition().getDefnShowName()));
            }
            tVideoNetInfo.setUpdateTimeMillis(System.currentTimeMillis());
            if (tVKLiveVideoInfo.getWatermarkInfos() != null && tVKLiveVideoInfo.getWatermarkInfos().size() != 0) {
                z16 = false;
            }
            tVideoNetInfo.setHasWatermark(z16);
            superPlayerVideoInfo.setTVideoNetInfo(tVideoNetInfo);
            VInfoCacheMgr.saveVInfoToCache(superPlayerVideoInfo);
            if (TVideoImpl.this.mListener != null) {
                TVideoImpl.this.mListener.onGetVInfoSuccess(superPlayerVideoInfo);
            }
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.TVKPlayerWrapperCGIModel.d
        public void onGetVodInfoFailed(int i3, b.c cVar, int i16, String str, int i17, String str2) {
            if (TVideoImpl.this.mListener != null) {
                if (i16 == 101) {
                    i16 = 5000;
                } else if (i16 == 103) {
                    i16 = 5001;
                }
                TVideoImpl.this.mListener.onGetVInfoFailed((SuperPlayerVideoInfo) cVar.r(), i16, i17, str);
            }
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.TVKPlayerWrapperCGIModel.d
        public void onGetVodInfoSuccess(int i3, b.c cVar, TVKVideoInfo tVKVideoInfo) {
            SuperPlayerVideoInfo superPlayerVideoInfo = (SuperPlayerVideoInfo) cVar.r();
            boolean z16 = true;
            if (tVKVideoInfo.getDownloadType() != 4 && tVKVideoInfo.getDownloadType() != 5) {
                if (tVKVideoInfo.getDownloadType() == 1) {
                    superPlayerVideoInfo.setFormat(301);
                    superPlayerVideoInfo.setPlayUrl(tVKVideoInfo.getPlayUrl());
                } else if (tVKVideoInfo.getDownloadType() == 3) {
                    superPlayerVideoInfo.setFormat(302);
                    superPlayerVideoInfo.setPlayUrl(tVKVideoInfo.getPlayUrl());
                } else {
                    superPlayerVideoInfo.setFormat(304);
                    superPlayerVideoInfo.setPlayUrl(tVKVideoInfo.getPlayUrl());
                }
            } else {
                superPlayerVideoInfo.setFormat(303);
                superPlayerVideoInfo.setTVideoSectionList(tVKVideoInfo.getSectionList());
            }
            superPlayerVideoInfo.setVideoDurationMs(tVKVideoInfo.getDuration() * 1000);
            TVideoNetInfo tVideoNetInfo = new TVideoNetInfo();
            tVideoNetInfo.setVideoDuration(tVKVideoInfo.getDuration() * 1000);
            tVideoNetInfo.setVideoSize(tVKVideoInfo.getFileSize());
            ArrayList<TVideoNetInfo.DefinitionInfo> arrayList = new ArrayList<>();
            if (tVKVideoInfo.getDefinitionList() != null) {
                Iterator<TVKNetVideoInfo.DefnInfo> it = tVKVideoInfo.getDefinitionList().iterator();
                while (it.hasNext()) {
                    TVKNetVideoInfo.DefnInfo next = it.next();
                    arrayList.add(new TVideoNetInfo.DefinitionInfo(next.getDefn(), next.getDefnName(), next.getDefnRate(), next.getDefnShowName()));
                }
            } else {
                LogUtil.e(TVideoImpl.TAG, "onGetVodInfoSuccess() reqType:" + i3 + "  liveInfo.getDefinitionList() == null");
            }
            tVideoNetInfo.setDefinitionList(arrayList);
            if (tVKVideoInfo.getCurDefinition() != null) {
                tVideoNetInfo.setCurrentDefinition(new TVideoNetInfo.DefinitionInfo(tVKVideoInfo.getCurDefinition().getDefn(), tVKVideoInfo.getCurDefinition().getDefnName(), tVKVideoInfo.getCurDefinition().getDefnRate(), tVKVideoInfo.getCurDefinition().getDefnShowName()));
            }
            tVideoNetInfo.setUpdateTimeMillis(System.currentTimeMillis());
            if (tVKVideoInfo.getWatermarkInfos() != null && tVKVideoInfo.getWatermarkInfos().size() != 0) {
                z16 = false;
            }
            tVideoNetInfo.setHasWatermark(z16);
            superPlayerVideoInfo.setTVideoNetInfo(tVideoNetInfo);
            VInfoCacheMgr.saveVInfoToCache(superPlayerVideoInfo);
            if (TVideoImpl.this.mListener != null) {
                TVideoImpl.this.mListener.onGetVInfoSuccess(superPlayerVideoInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TVideoImpl(Context context, Looper looper) {
        this.mContext = context;
        this.mWrapperCGI = new TVKPlayerWrapperCGIModel(looper, this.mWrapperCGICallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doGetVInfo(SuperPlayerVideoInfo superPlayerVideoInfo) {
        int i3;
        VInfoGetter.VInfoGetterListener vInfoGetterListener;
        SuperPlayerVideoInfo vInfoFromCache = VInfoCacheMgr.getVInfoFromCache(superPlayerVideoInfo);
        if (vInfoFromCache != null && (vInfoGetterListener = this.mListener) != null) {
            vInfoGetterListener.onGetVInfoSuccess(vInfoFromCache);
            return;
        }
        int videoType = superPlayerVideoInfo.getVideoType();
        if (videoType != 1) {
            if (videoType != 2) {
                LogUtil.e(TAG, "doGetVInfo() playerVideoInfo.getVideoType() is ERROR = " + superPlayerVideoInfo.getVideoType());
                return;
            }
            i3 = 1;
        } else {
            i3 = 2;
        }
        TVKPlayerVideoInfo tVKPlayerVideoInfo = new TVKPlayerVideoInfo(i3, superPlayerVideoInfo.getVid(), superPlayerVideoInfo.getPid());
        tVKPlayerVideoInfo.setPid(superPlayerVideoInfo.getPid());
        tVKPlayerVideoInfo.setPlatform(superPlayerVideoInfo.getBusiPlatform());
        c cVar = new c();
        cVar.b(this.mContext);
        TVKUserInfo tVKUserInfo = new TVKUserInfo();
        tVKUserInfo.setLoginCookie(superPlayerVideoInfo.getTVideoLoginCookie());
        cVar.j(tVKUserInfo);
        cVar.l(tVKPlayerVideoInfo);
        cVar.d(superPlayerVideoInfo.getRequestDefinition());
        cVar.h(new TVKMediaSource(tVKPlayerVideoInfo));
        b bVar = new b();
        bVar.b().k(cVar.e());
        bVar.b().e(cVar.c());
        if (superPlayerVideoInfo.getVideoType() == 1) {
            bVar.b().m(1);
        } else {
            bVar.b().m(2);
        }
        bVar.b().s(superPlayerVideoInfo);
        this.mWrapperCGI.u(0, cVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setListener(VInfoGetter.VInfoGetterListener vInfoGetterListener) {
        this.mListener = vInfoGetterListener;
    }
}
