package na4;

import android.net.Uri;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.player.f;
import com.tencent.sqshow.zootopia.player.preload.bean.VideoUrlBean;
import com.tencent.sqshow.zootopia.utils.VideoUtils;
import com.tencent.sqshow.zootopia.utils.g;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import na4.d;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J4\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000b2\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000bH\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u000bH\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0002J$\u0010\u0019\u001a\u0004\u0018\u00010\b2\u0010\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u000b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J*\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u001c\u0010\u001e\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006!"}, d2 = {"Lna4/b;", "Lna4/a;", "Lcom/tencent/sqshow/zootopia/player/f;", "options", "Lna4/d$b;", "callBack", "", "j", "Lcom/tencent/sqshow/zootopia/player/preload/bean/VideoUrlBean;", "g", "serverBean", "", "targetBeanH264", "targetBeanH265", "i", "d", "list", "c", h.F, "e", "serverPlayBean", "k", "beans", "", "formatId", "f", "targetBean", "", "hasDownLevel", "l", "b", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends a {
    private final VideoUrlBean d(f options) {
        VideoUrlBean mServerPlayBean = options.getMServerPlayBean();
        List<VideoUrlBean> i3 = options.i();
        Intrinsics.checkNotNull(mServerPlayBean);
        if (mServerPlayBean.getMVideoEncode() == 2) {
            Intrinsics.checkNotNull(i3);
            for (VideoUrlBean videoUrlBean : i3) {
                Intrinsics.checkNotNull(mServerPlayBean);
                int mRate = mServerPlayBean.getMRate();
                Intrinsics.checkNotNull(videoUrlBean);
                if (mRate > videoUrlBean.getMRate()) {
                    mServerPlayBean = videoUrlBean;
                }
            }
            return mServerPlayBean;
        }
        Intrinsics.checkNotNull(i3);
        VideoUrlBean videoUrlBean2 = mServerPlayBean;
        for (VideoUrlBean videoUrlBean3 : i3) {
            Intrinsics.checkNotNull(videoUrlBean2);
            int mRate2 = videoUrlBean2.getMRate();
            Intrinsics.checkNotNull(videoUrlBean3);
            if (mRate2 > videoUrlBean3.getMRate() && videoUrlBean3.getMVideoEncode() == mServerPlayBean.getMVideoEncode()) {
                videoUrlBean2 = videoUrlBean3;
            }
        }
        return videoUrlBean2;
    }

    private final void e(f options, d.b callBack) {
        VideoUrlBean mServerPlayBean = options.getMServerPlayBean();
        VideoUrlBean mRealPlayBean = options.getMRealPlayBean();
        if (mRealPlayBean == null) {
            mRealPlayBean = k(options, mServerPlayBean);
        }
        if (mRealPlayBean == null) {
            QLog.i(a(options), 1, "forceDownUrlLevel, failed no play url");
            callBack.a(options, true);
            return;
        }
        List<VideoUrlBean> i3 = options.i();
        Intrinsics.checkNotNull(i3);
        for (VideoUrlBean videoUrlBean : i3) {
            Intrinsics.checkNotNull(videoUrlBean);
            int mVideoEncode = videoUrlBean.getMVideoEncode();
            Intrinsics.checkNotNull(mServerPlayBean);
            if (mVideoEncode == mServerPlayBean.getMVideoEncode() && videoUrlBean.getMRate() < mRealPlayBean.getMRate()) {
                QLog.i(a(options), 1, "forceDownUrlLevel, findUrlBen:" + videoUrlBean);
                l(options, callBack, videoUrlBean, true);
                return;
            }
        }
        QLog.i(a(options), 1, "forceDownUrlLevel, not find lower url");
        String mUrl = mRealPlayBean.getMUrl();
        Intrinsics.checkNotNull(mServerPlayBean);
        l(options, callBack, mRealPlayBean, !Intrinsics.areEqual(mUrl, mServerPlayBean.getMUrl()));
    }

    private final VideoUrlBean f(List<VideoUrlBean> beans, int formatId) {
        Intrinsics.checkNotNull(beans);
        for (VideoUrlBean videoUrlBean : beans) {
            Intrinsics.checkNotNull(videoUrlBean);
            if (formatId == videoUrlBean.getMFormatId()) {
                return videoUrlBean;
            }
        }
        return null;
    }

    private final VideoUrlBean g(f options) {
        VideoUrlBean mServerPlayBean = options.getMServerPlayBean();
        Intrinsics.checkNotNull(mServerPlayBean);
        int mRate = mServerPlayBean.getMRate() / 8;
        long i3 = VideoUtils.f373236a.i();
        options.q((int) i3);
        String str = "|serverBeanRate:" + mRate + "KB/S|preDictSpeed:" + i3 + "KB/S";
        if (mRate < i3) {
            QLog.i(a(options), 1, "getTargetBeanByPredictSpeed() use serverBean:" + str);
            return mServerPlayBean;
        }
        List<VideoUrlBean> i16 = options.i();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Intrinsics.checkNotNull(i16);
        for (VideoUrlBean videoUrlBean : i16) {
            Intrinsics.checkNotNull(videoUrlBean);
            if (videoUrlBean.getMRate() / 8 < i3) {
                if (videoUrlBean.getMVideoEncode() == 2) {
                    arrayList2.add(videoUrlBean);
                } else {
                    arrayList.add(videoUrlBean);
                }
            }
        }
        String str2 = str + "|mTargetBeanH265.size():" + arrayList2.size() + "|mTargetBeanH264.size():" + arrayList.size();
        VideoUrlBean i17 = i(mServerPlayBean, arrayList, arrayList2);
        if (i17 != null) {
            String str3 = str2 + "|resultBeanRate:" + (i17.getMRate() / 8) + "KB/S";
            QLog.i(a(options), 1, "getTargetBeanByPredictSpeed() find int filter:" + str3);
            return i17;
        }
        VideoUrlBean d16 = d(options);
        Intrinsics.checkNotNull(d16);
        String str4 = str2 + "|resultBeanRate:" + (d16.getMRate() / 8) + "KB/S";
        QLog.i(a(options), 1, "getTargetBeanByPredictSpeed() by all search :" + str4);
        return d16;
    }

    private final VideoUrlBean h(f options) {
        VideoUrlBean mServerPlayBean = options.getMServerPlayBean();
        VideoUtils videoUtils = VideoUtils.f373236a;
        Intrinsics.checkNotNull(mServerPlayBean);
        if (videoUtils.b(mServerPlayBean.getMUrl(), options.j())) {
            QLog.i(a(options), 1, "getTargetBeanIfHasCache() hit serverBean");
            return mServerPlayBean;
        }
        List<VideoUrlBean> i3 = options.i();
        Intrinsics.checkNotNull(i3);
        for (VideoUrlBean videoUrlBean : i3) {
            VideoUtils videoUtils2 = VideoUtils.f373236a;
            Intrinsics.checkNotNull(videoUrlBean);
            if (videoUtils2.b(videoUrlBean.getMUrl(), options.j())) {
                QLog.i(a(options), 1, "getTargetBeanIfHasCache() hit vecBean");
                return videoUrlBean;
            }
        }
        return null;
    }

    private final VideoUrlBean i(VideoUrlBean serverBean, List<VideoUrlBean> targetBeanH264, List<VideoUrlBean> targetBeanH265) {
        Intrinsics.checkNotNull(serverBean);
        if (serverBean.getMVideoEncode() == 2) {
            VideoUrlBean c16 = c(targetBeanH265);
            return c16 == null ? c(targetBeanH264) : c16;
        }
        return c(targetBeanH264);
    }

    private final void j(f options, d.b callBack) {
        VideoUrlBean mServerPlayBean = options.getMServerPlayBean();
        if (uq3.c.p0() && !g.f373269a.f()) {
            VideoUrlBean h16 = h(options);
            if (h16 != null) {
                QLog.i(a(options), 1, "selectUrlByDownloadSpeed()| use cache url:" + h16.getMUrl());
                options.t(true);
                String mUrl = h16.getMUrl();
                Intrinsics.checkNotNull(mServerPlayBean);
                l(options, callBack, h16, !Intrinsics.areEqual(mUrl, mServerPlayBean.getMUrl()));
                return;
            }
            VideoUrlBean g16 = g(options);
            String a16 = a(options);
            Intrinsics.checkNotNull(g16);
            QLog.i(a16, 1, "selectUrlByDownloadSpeed()| finTarget:" + g16.getMUrl());
            String mUrl2 = g16.getMUrl();
            Intrinsics.checkNotNull(mServerPlayBean);
            l(options, callBack, g16, Intrinsics.areEqual(mUrl2, mServerPlayBean.getMUrl()) ^ true);
            return;
        }
        QLog.i(a(options), 1, "selectUrlByDownloadSpeed()| not enable");
        l(options, callBack, mServerPlayBean, false);
    }

    private final VideoUrlBean k(f options, VideoUrlBean serverPlayBean) {
        Uri realPlayUri = Uri.parse(options.d());
        VideoUrlBean.Companion companion = VideoUrlBean.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(realPlayUri, "realPlayUri");
        int e16 = companion.e(realPlayUri);
        Intrinsics.checkNotNull(serverPlayBean);
        if (serverPlayBean.getMFormatId() == e16) {
            QLog.i(a(options), 1, "tryGetRealPlayVideoUrlBean, current playing url is server url ");
            return serverPlayBean;
        }
        return f(options.i(), e16);
    }

    private final void l(f options, d.b callBack, VideoUrlBean targetBean, boolean hasDownLevel) {
        String str;
        f r16 = options.r(targetBean);
        if (targetBean == null || (str = targetBean.getMUrl()) == null) {
            str = "";
        }
        r16.s(str).n(hasDownLevel);
        callBack.a(options, true);
    }

    private final VideoUrlBean c(List<VideoUrlBean> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        VideoUrlBean videoUrlBean = list.get(0);
        for (VideoUrlBean videoUrlBean2 : list) {
            Intrinsics.checkNotNull(videoUrlBean2);
            int mRate = videoUrlBean2.getMRate();
            Intrinsics.checkNotNull(videoUrlBean);
            if (mRate > videoUrlBean.getMRate()) {
                videoUrlBean = videoUrlBean2;
            }
        }
        return videoUrlBean;
    }

    @Override // na4.a
    public void b(f options, d.b callBack) {
        if (options == null || callBack == null) {
            return;
        }
        if (options.getStVideoMaterial() == null) {
            QLog.i(a(options), 1, "selectUrlByDownloadSpeed() null video");
            options.s(options.d()).n(false);
            callBack.a(options, true);
            return;
        }
        if (options.i() == null) {
            options.w(VideoUrlBean.INSTANCE.g(options.c()));
        }
        if (options.getMServerPlayBean() == null) {
            options.u(new VideoUrlBean(options.getStVideoMaterial()));
        }
        QLog.i(a(options), 1, "server url: " + options.d());
        if (options.getMNeedToDownLevelUrl()) {
            e(options, callBack);
        } else {
            j(options, callBack);
        }
    }
}
