package com.tencent.mobileqq.guild.feed.part.GalleryUtils;

import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;
import com.tencent.biz.qcircleshadow.lib.variation.HostFileUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostHttpUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.guild.feed.share.GuildFeedRichMediaDownLoadManager;
import com.tencent.mobileqq.guild.picload.e;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.richframework.thread.RFWThreadManager;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yl1.n;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J:\u0010\f\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002J(\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/part/GalleryUtils/GalleryPicTransUtils;", "", "", "netUrl", "a", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStImage;", "image", "", "isQuality", "Lkotlin/Function2;", "", "doOpenEditPageCb", "c", "Lcom/tencent/mobileqq/guild/feed/share/GuildFeedRichMediaDownLoadManager$DownLoadParams;", "params", "b", "d", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GalleryPicTransUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GalleryPicTransUtils f222415a = new GalleryPicTransUtils();

    GalleryPicTransUtils() {
    }

    private final String a(String netUrl) {
        Option option = new Option();
        option.setUrl(netUrl);
        String c16 = e.a().c(option);
        Intrinsics.checkNotNullExpressionValue(c16, "g().getPicLocalPath(option)");
        return c16;
    }

    private final void b(final GuildFeedRichMediaDownLoadManager.DownLoadParams params) {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.part.GalleryUtils.GalleryPicTransUtils$downloadDirect$1
            @Override // java.lang.Runnable
            public void run() {
                HttpNetReq httpNetReq = new HttpNetReq();
                GuildFeedRichMediaDownLoadManager.DownLoadParams downLoadParams = GuildFeedRichMediaDownLoadManager.DownLoadParams.this;
                httpNetReq.mCallback = new a(downLoadParams);
                httpNetReq.mReqUrl = downLoadParams.d();
                httpNetReq.mHttpMethod = 0;
                httpNetReq.mOutPath = downLoadParams.f();
                httpNetReq.mContinuErrorLimit = HostNetworkUtils.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
                HostHttpUtils.httpEngineServiceSendRequest(httpNetReq);
                HostStaticInvokeHelper.addNetworkChangedObserver(new GuildFeedRichMediaDownLoadManager.b(GuildFeedRichMediaDownLoadManager.DownLoadParams.this, httpNetReq));
            }

            @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\u000b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/feed/part/GalleryUtils/GalleryPicTransUtils$downloadDirect$1$a", "Lcom/tencent/mobileqq/transfile/INetEngineListener;", "Lcom/tencent/mobileqq/transfile/NetResp;", "resp", "", "onResp", "Lcom/tencent/mobileqq/transfile/NetReq;", "req", "", "curOffset", "totalLen", "onUpdateProgeress", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a implements INetEngineListener {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ GuildFeedRichMediaDownLoadManager.DownLoadParams f222420d;

                a(GuildFeedRichMediaDownLoadManager.DownLoadParams downLoadParams) {
                    this.f222420d = downLoadParams;
                }

                @Override // com.tencent.mobileqq.transfile.INetEngineListener
                public void onResp(@Nullable NetResp resp) {
                    if (resp == null) {
                        return;
                    }
                    int i3 = resp.mResult;
                    boolean z16 = true;
                    if (i3 == 0) {
                        QLog.i("GalleryPicTransUtils", 1, "[transNetworkPicUrlToLocal]--download success:" + this.f222420d.d());
                    } else if (i3 == 1 || i3 == 2) {
                        QLog.i("GalleryPicTransUtils", 1, "[transNetworkPicUrlToLocal]--download fail:" + this.f222420d.d());
                        HostFileUtils.delete(this.f222420d.f(), true);
                    }
                    GuildFeedRichMediaDownLoadManager.c e16 = this.f222420d.e();
                    if (e16 != null) {
                        if (resp.mResult != 0) {
                            z16 = false;
                        }
                        e16.onStatusChange(z16);
                    }
                }

                @Override // com.tencent.mobileqq.transfile.INetEngineListener
                public void onUpdateProgeress(@Nullable NetReq req, long curOffset, long totalLen) {
                }
            }
        });
    }

    private final void c(GProStImage image, String netUrl, boolean isQuality, Function2<? super String, ? super Boolean, Unit> doOpenEditPageCb) {
        int i3;
        GuildFeedRichMediaDownLoadManager.DownLoadParams downLoadParams = new GuildFeedRichMediaDownLoadManager.DownLoadParams();
        if (image.isGif) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        downLoadParams.i(netUrl, i3, image.picId);
        downLoadParams.h(new a(doOpenEditPageCb, downLoadParams, isQuality));
        if (HostFileUtils.fileExists(downLoadParams.f())) {
            QLog.i("GalleryPicTransUtils", 1, "[transNetworkPicUrlToLocal]--save cached path exist:" + downLoadParams.f());
            String f16 = downLoadParams.f();
            Intrinsics.checkNotNullExpressionValue(f16, "params.saveCachePath");
            doOpenEditPageCb.invoke(f16, Boolean.valueOf(isQuality));
            return;
        }
        b(downLoadParams);
    }

    public final void d(@NotNull GProStImage image, @NotNull Function2<? super String, ? super Boolean, Unit> doOpenEditPageCb) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(doOpenEditPageCb, "doOpenEditPageCb");
        String netUrl = image.getPicUrl();
        boolean isOrig = image.getIsOrig();
        Intrinsics.checkNotNullExpressionValue(netUrl, "netUrl");
        String a16 = a(netUrl);
        if (!TextUtils.isEmpty(a16) && new File(a16).exists()) {
            QLog.i("GalleryPicTransUtils", 1, "[transNetworkPicUrlToLocal]--use local cache path:" + a16);
            doOpenEditPageCb.invoke(a16, Boolean.valueOf(isOrig));
            return;
        }
        c(image, netUrl, isOrig, doOpenEditPageCb);
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/feed/part/GalleryUtils/GalleryPicTransUtils$a", "Lcom/tencent/mobileqq/guild/feed/share/GuildFeedRichMediaDownLoadManager$c;", "", "a", "", "success", "onStatusChange", "", "progress", "onProgress", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements GuildFeedRichMediaDownLoadManager.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<String, Boolean, Unit> f222416a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildFeedRichMediaDownLoadManager.DownLoadParams f222417b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f222418c;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function2<? super String, ? super Boolean, Unit> function2, GuildFeedRichMediaDownLoadManager.DownLoadParams downLoadParams, boolean z16) {
            this.f222416a = function2;
            this.f222417b = downLoadParams;
            this.f222418c = z16;
        }

        @Override // com.tencent.mobileqq.guild.feed.share.GuildFeedRichMediaDownLoadManager.c
        public void onStatusChange(boolean success) {
            if (success) {
                Function2<String, Boolean, Unit> function2 = this.f222416a;
                String saveCachePath = this.f222417b.f();
                Intrinsics.checkNotNullExpressionValue(saveCachePath, "saveCachePath");
                function2.invoke(saveCachePath, Boolean.valueOf(this.f222418c));
                return;
            }
            n.A(1, "\u7f51\u7edc\u9519\u8bef!\u8bf7\u91cd\u8bd5");
        }

        @Override // com.tencent.mobileqq.guild.feed.share.GuildFeedRichMediaDownLoadManager.c
        public void a() {
        }

        @Override // com.tencent.mobileqq.guild.feed.share.GuildFeedRichMediaDownLoadManager.c
        public void onProgress(int progress) {
        }
    }
}
