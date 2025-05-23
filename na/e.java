package na;

import com.google.protobuf.nano.MessageNano;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.base.n;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.RichTextHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.VipNtMMKV;
import com.tencent.mobileqq.vas.api.IPbProtocol;
import com.tencent.mobileqq.vas.troop.e;
import com.tencent.mobileqq.vas.troop.f;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nq3.g;
import nq3.h;
import qzone.QZonePhotoDegrade$Button;
import qzone.QZonePhotoDegrade$QueryNotifyMsgRsp;
import qzone.QZonePhotoDegrade$Text;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\"\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u0004J\u0014\u0010\u000f\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e\u00a8\u0006\u0012"}, d2 = {"Lna/e;", "", "", "scene", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/vas/troop/e$c;", "", "callback", "b", "d", "", "uin", "", "c", "Lkotlin/Function0;", "e", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f419543a = new e();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"na/e$a", "Lcom/qzone/reborn/base/n$a;", "Lqzone/QZonePhotoDegrade$QueryNotifyMsgRsp;", "data", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a implements n.a<QZonePhotoDegrade$QueryNotifyMsgRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f419544a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<e.DialogData, Unit> f419545b;

        /* JADX WARN: Multi-variable type inference failed */
        a(int i3, Function1<? super e.DialogData, Unit> function1) {
            this.f419544a = i3;
            this.f419545b = function1;
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(QZonePhotoDegrade$QueryNotifyMsgRsp data, long retCode, String msg2, boolean isFinish) {
            e.DialogData dialogData;
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            ArrayList arrayList = new ArrayList();
            List<QZonePhotoDegrade$Text> list = data.f430342msg.texts.get();
            Intrinsics.checkNotNullExpressionValue(list, "data.msg.texts.get()");
            String str = "";
            for (QZonePhotoDegrade$Text qZonePhotoDegrade$Text : list) {
                str = ((Object) str) + qZonePhotoDegrade$Text.f430343msg.get();
                if (qZonePhotoDegrade$Text.type.get() == 1) {
                    arrayList.add(new RichTextHelper.RichTextData(qZonePhotoDegrade$Text.f430343msg.get(), qZonePhotoDegrade$Text.url.get()));
                }
            }
            List<QZonePhotoDegrade$Button> list2 = data.f430342msg.buttons.get();
            String title = data.f430342msg.title.get();
            if (!(str.length() == 0) && list2.size() == 2) {
                int i3 = this.f419544a;
                if (i3 != 3) {
                    if (i3 != 4) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(title, "title");
                    String str2 = list2.get(0).f430341msg.get();
                    Intrinsics.checkNotNullExpressionValue(str2, "buttons[0].msg.get()");
                    String str3 = list2.get(0).url.get();
                    Intrinsics.checkNotNullExpressionValue(str3, "buttons[0].url.get()");
                    e.Button button = new e.Button(str2, str3);
                    String str4 = list2.get(1).f430341msg.get();
                    Intrinsics.checkNotNullExpressionValue(str4, "buttons[1].msg.get()");
                    String str5 = list2.get(1).url.get();
                    Intrinsics.checkNotNullExpressionValue(str5, "buttons[1].url.get()");
                    dialogData = new e.DialogData(title, str, arrayList, "", button, new e.Button(str4, str5));
                } else {
                    Intrinsics.checkNotNullExpressionValue(title, "title");
                    String str6 = list2.get(0).f430341msg.get();
                    Intrinsics.checkNotNullExpressionValue(str6, "buttons[0].msg.get()");
                    String str7 = list2.get(0).url.get();
                    Intrinsics.checkNotNullExpressionValue(str7, "buttons[0].url.get()");
                    e.Button button2 = new e.Button(str6, str7);
                    String str8 = list2.get(1).f430341msg.get();
                    Intrinsics.checkNotNullExpressionValue(str8, "buttons[1].msg.get()");
                    String str9 = list2.get(1).url.get();
                    Intrinsics.checkNotNullExpressionValue(str9, "buttons[1].url.get()");
                    dialogData = new e.DialogData(title, str, arrayList, "\u4e0b\u6b21\u4e0d\u518d\u63d0\u9192", button2, new e.Button(str8, str9));
                }
                this.f419545b.invoke(dialogData);
                return;
            }
            f.f311020a.f("request data is nul content : " + ((Object) str) + ", buttons size " + list2);
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            f.f311020a.f("request error errorCode : " + errorCode + ", errorMsg " + errorMsg);
        }
    }

    e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function0 callback, int i3, boolean z16, Object obj) {
        g gVar;
        nq3.f fVar;
        h hVar;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (z16 && obj != null) {
            nq3.c c16 = nq3.c.c(obj instanceof byte[] ? (byte[]) obj : null);
            if (c16 != null && (gVar = c16.f420701a) != null && (fVar = gVar.f420714a) != null && (hVar = fVar.f420711a) != null) {
                if (hVar.f420717a) {
                    VipNtMMKV.INSTANCE.getCommon(LoginData.getInstance().getUinString()).encodeBool("vas_qzone_vip_pay", true);
                    f.f311020a.f("rsp is vip");
                    callback.invoke();
                    return;
                }
                f.f311020a.f("rsp success is not vip");
            }
            f.f311020a.f("rsp is null");
            return;
        }
        f.f311020a.f("request error " + z16);
    }

    public final void b(int scene, Function1<? super e.DialogData, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        c.f419539a.i(scene, new a(scene, callback));
    }

    public final void c(long uin, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (uin == 0) {
            f.f311020a.f("uin is invalid");
        } else {
            c.f419539a.g(uin, callback);
        }
    }

    public final void d(int scene) {
        c.f419539a.c(scene);
    }

    public final void e(final Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        VasLogReporter.INSTANCE.getQzoneVip().reportLow("requestVipInfo");
        nq3.b bVar = new nq3.b();
        bVar.f420700a = 1;
        ((IPbProtocol) QRoute.api(IPbProtocol.class)).request("trpc.commvip.growth_basic.SsoService.SsoGetInfo", MessageNano.toByteArray(bVar), new BusinessObserver() { // from class: na.d
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                e.f(Function0.this, i3, z16, obj);
            }
        });
    }
}
