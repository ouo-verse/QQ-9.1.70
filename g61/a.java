package g61;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.partner.IPartnerApi;
import com.tencent.mobileqq.partner.signin.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IAIOEmoApi;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.LIAInjectUtil;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.LIAScene;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.c;
import com.tencent.qqnt.kernel.api.IUixConvertAdapterApi;
import com.tencent.qqnt.kernel.nativeinterface.LiteActionType;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\u0018\u0000 \u00062\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0011R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0015R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lg61/a;", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/c;", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/LIAInjectUtil$a;", "extraInfo", "", "c", "d", "b", "Landroid/view/View;", "view", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/LIAScene;", "scene", "", "a", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "types", "", "", "Ljava/util/Map;", "defaultSearchWords", "", "typeToMutualMarkId", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<Integer> types;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Integer, String> defaultSearchWords;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Integer, Integer> typeToMutualMarkId;

    public a() {
        ArrayList<Integer> arrayListOf;
        Map<Integer, String> mutableMapOf;
        Map<Integer, Integer> mapOf;
        LiteActionType liteActionType = LiteActionType.KSTUDYPARTNER;
        LiteActionType liteActionType2 = LiteActionType.KSPORTPARTNER;
        LiteActionType liteActionType3 = LiteActionType.KMETADREAMPARTNER;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Integer.valueOf(liteActionType.ordinal()), Integer.valueOf(liteActionType2.ordinal()), Integer.valueOf(liteActionType3.ordinal()));
        this.types = arrayListOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(Integer.valueOf(liteActionType.ordinal()), "\u5b66\u4e60\u5427"), TuplesKt.to(Integer.valueOf(liteActionType2.ordinal()), "\u8fd0\u52a8\u5427"), TuplesKt.to(Integer.valueOf(liteActionType3.ordinal()), "\u5f00\u9ed1\u5417"));
        this.defaultSearchWords = mutableMapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(Integer.valueOf(liteActionType.ordinal()), 81), TuplesKt.to(Integer.valueOf(liteActionType2.ordinal()), 82), TuplesKt.to(Integer.valueOf(liteActionType3.ordinal()), 90));
        this.typeToMutualMarkId = mapOf;
    }

    private final void b(LIAInjectUtil.a extraInfo) {
        String str;
        int i3;
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        com.tencent.aio.api.runtime.a a16 = extraInfo.a();
        if (a16 == null || (g16 = a16.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || (str = c16.j()) == null) {
            Contact b16 = extraInfo.b();
            if (b16 != null) {
                str = b16.peerUid;
            } else {
                str = null;
            }
        }
        if (str == null) {
            QLog.e("IntimateLIAClickProcessor", 1, "[doPartnerSignIn] err when peerUid is null!");
            return;
        }
        long uinFromUid = ((IUixConvertAdapterApi) QRoute.api(IUixConvertAdapterApi.class)).getUinFromUid(str);
        Integer num = this.typeToMutualMarkId.get(Integer.valueOf(extraInfo.d().getType()));
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        ((IPartnerApi) QRoute.api(IPartnerApi.class)).openPartnerSignInDialog(new i(String.valueOf(uinFromUid), i3, null, "1"));
    }

    private final void c(LIAInjectUtil.a extraInfo) {
        boolean z16;
        String title = extraInfo.d().getTitle();
        if (title.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && (title = this.defaultSearchWords.get(Integer.valueOf(extraInfo.d().getType()))) == null) {
            title = "";
        }
        String str = title;
        com.tencent.aio.api.runtime.a a16 = extraInfo.a();
        Contact b16 = extraInfo.b();
        if (a16 != null) {
            ((IAIOEmoApi) QRoute.api(IAIOEmoApi.class)).sendRandomPicEmotionMsgFromAIO(str, a16);
        } else if (b16 != null) {
            QRouteApi api = QRoute.api(IAIOEmoApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IAIOEmoApi::class.java)");
            IAIOEmoApi.a.b((IAIOEmoApi) api, str, b16, null, 4, null);
        }
    }

    private final void d(LIAInjectUtil.a extraInfo) {
        String str;
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        com.tencent.aio.api.runtime.a a16 = extraInfo.a();
        Contact b16 = extraInfo.b();
        if (a16 == null || (g16 = a16.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || (str = c16.j()) == null) {
            if (b16 != null) {
                str = b16.peerUid;
            } else {
                str = null;
            }
        }
        if (str == null) {
            QLog.e("IntimateLIAClickProcessor", 1, "[doTeamUpAction] err when peerUid is null!");
            return;
        }
        Bundle bundle = new Bundle();
        long uinFromUid = ((IUixConvertAdapterApi) QRoute.api(IUixConvertAdapterApi.class)).getUinFromUid(str);
        bundle.putLong(ProtocolDownloaderConstants.HEADER_FRIEND_UIN, uinFromUid);
        bundle.putString("peer_uid", str);
        bundle.putInt("uinType", 0);
        bundle.putString("friend_uin", String.valueOf(uinFromUid));
        if (QLog.isDevelopLevel()) {
            QLog.d("IntimateLIAClickProcessor", 1, "[doTeamUpAction] extraInfo=" + bundle);
        }
        Intent intent = new Intent();
        intent.putExtra("url", "https://h5.qun.qq.com/h5/qun-yuanmeng-team-up/home?_wv=1&_wwv=8193&_disableWVQuit=1&big_brother_source_key=biz_src_qun_yuan_meng&scene=2");
        intent.putExtras(bundle);
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity != null) {
            RouteUtils.startActivity(topActivity, intent, RouterConstants.UI_ROUTE_BROWSER);
        }
    }

    @Override // com.tencent.qqnt.biz.lightbusiness.lightinteraction.c
    public boolean a(@Nullable View view, @NotNull LIAScene scene, @NotNull LIAInjectUtil.a extraInfo) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        boolean z16 = false;
        if (!this.types.contains(Integer.valueOf(extraInfo.d().getType()))) {
            return false;
        }
        QLog.i("IntimateLIAClickProcessor", 1, "handleClick scene=" + scene + " type=" + extraInfo.d().getType() + " mode=" + extraInfo.d().a());
        int type = extraInfo.d().getType();
        if (type == LiteActionType.KSTUDYPARTNER.ordinal() || type == LiteActionType.KSPORTPARTNER.ordinal()) {
            z16 = true;
        }
        if (z16) {
            if (extraInfo.d().a() == 3) {
                b(extraInfo);
            } else {
                c(extraInfo);
            }
        } else if (type == LiteActionType.KMETADREAMPARTNER.ordinal()) {
            if (extraInfo.d().a() == 2) {
                d(extraInfo);
            } else {
                c(extraInfo);
            }
        } else {
            c(extraInfo);
        }
        return true;
    }
}
