package ki;

import com.qzone.common.account.LoginData;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.reborn.base.n;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetQunNoticeListCallback;
import com.tencent.qqnt.kernel.nativeinterface.Notice;
import com.tencent.qqnt.kernel.nativeinterface.StCommonExt;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.QUA;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ6\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J,\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0016J,\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0016R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lki/ad;", "", "", "groupId", "Lcom/tencent/qqnt/kernel/nativeinterface/StCommonExt;", "commonExt", "reqAttachInfo", "Lcom/qzone/reborn/base/n$a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/Notice;", "dataCallback", "", "c", "Lcom/tencent/qqnt/kernel/api/g;", "f", "", "contextHashCode", tl.h.F, "g", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/StCommonExt;", "mCommonExt", "b", "Ljava/lang/String;", "mAttachInfo", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public class ad {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private StCommonExt mCommonExt = new StCommonExt();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String mAttachInfo = "";

    private final void c(final String groupId, StCommonExt commonExt, String reqAttachInfo, final n.a<List<Notice>> dataCallback) {
        IAlbumServiceGetQunNoticeListCallback iAlbumServiceGetQunNoticeListCallback = new IAlbumServiceGetQunNoticeListCallback() { // from class: ki.ab
            @Override // com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetQunNoticeListCallback
            public final void onGetQunNoticeList(int i3, int i16, String str, StCommonExt stCommonExt, ArrayList arrayList, String str2, boolean z16) {
                ad.d(groupId, this, dataCallback, i3, i16, str, stCommonExt, arrayList, str2, z16);
            }
        };
        com.tencent.qqnt.kernel.api.g f16 = f();
        if (f16 != null) {
            f16.h(commonExt, groupId, reqAttachInfo, iAlbumServiceGetQunNoticeListCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(final String groupId, final ad this$0, final n.a dataCallback, final int i3, final int i16, final String str, final StCommonExt stCommonExt, final ArrayList arrayList, final String str2, final boolean z16) {
        Intrinsics.checkNotNullParameter(groupId, "$groupId");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dataCallback, "$dataCallback");
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: ki.ac
            @Override // java.lang.Runnable
            public final void run() {
                ad.e(i3, groupId, i16, this$0, stCommonExt, str2, dataCallback, arrayList, str, z16);
            }
        });
    }

    private final com.tencent.qqnt.kernel.api.g f() {
        IKernelService iKernelService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        com.tencent.qqnt.kernel.api.g albumService = (peekAppRuntime == null || (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "all")) == null) ? null : iKernelService.getAlbumService();
        if (albumService != null) {
            albumService.setAlbumServiceInfo(LoginData.getInstance().getUinString(), QUA.getQUA3(), QZoneRequest.getDeiviceInfoDetailInner(false));
        }
        return albumService;
    }

    public void g(int contextHashCode, String groupId, n.a<List<Notice>> dataCallback) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        c(groupId, this.mCommonExt, this.mAttachInfo, dataCallback);
    }

    public void h(int contextHashCode, String groupId, n.a<List<Notice>> dataCallback) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        c(groupId, new StCommonExt(), "", dataCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(int i3, String groupId, int i16, ad this$0, StCommonExt stCommonExt, String str, n.a dataCallback, ArrayList notices, String str2, boolean z16) {
        Intrinsics.checkNotNullParameter(groupId, "$groupId");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dataCallback, "$dataCallback");
        RFWLog.e("GroupAlbumNoticeServerRepo", RFWLog.USR, "doRequestNotice seq:" + i3 + " groupId:" + groupId + "  ret\uff1a" + i16 + " ");
        this$0.mCommonExt = stCommonExt == null ? new StCommonExt() : stCommonExt;
        this$0.mAttachInfo = str == null ? "" : str;
        if (i16 == 0) {
            Intrinsics.checkNotNullExpressionValue(notices, "notices");
            dataCallback.onSuccess(notices, i16, str2 != null ? str2 : "", !z16);
        } else {
            dataCallback.onFailure(i16, str2);
        }
    }
}
