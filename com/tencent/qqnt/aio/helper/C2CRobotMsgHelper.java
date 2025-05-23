package com.tencent.qqnt.aio.helper;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.data.AIOParam;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.AIOLifeCycleEvent;
import com.tencent.robot.slash.input.InputRobotMsgIntent;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import tencent.im.oidb.cmd0x934.cmd0x934$RspBody;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J&\u0010\u000b\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u001c\u0010\u0017\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0015j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016R\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u0019\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/qqnt/aio/helper/C2CRobotMsgHelper;", "Lcom/tencent/qqnt/aio/helper/BaseLifecycleHelper;", "", tl.h.F, "j", "", "content", "o", "strTroopUin", "strRobotUin", "strContent", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "url", "k", "", "getId", "getTag", "", "interestedIn", "state", "onMoveToState", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "a", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "e", "Lcom/tencent/mobileqq/troop/robot/api/ITroopRobotService;", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/troop/robot/api/ITroopRobotService;", "troopRobotService", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes34.dex */
public final class C2CRobotMsgHelper extends BaseLifecycleHelper {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy troopRobotService;

    public C2CRobotMsgHelper() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ITroopRobotService>() { // from class: com.tencent.qqnt.aio.helper.C2CRobotMsgHelper$troopRobotService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ITroopRobotService invoke() {
                return RobotPanelLayoutBase.s();
            }
        });
        this.troopRobotService = lazy;
    }

    private final void h() {
        j();
    }

    private final ITroopRobotService i() {
        return (ITroopRobotService) this.troopRobotService.getValue();
    }

    private final void k(String url) {
        Fragment c16;
        QLog.i("C2CRobotMsgHelper", 1, "[jumpToWeb] url:" + url);
        com.tencent.aio.api.runtime.a aioContext = getAioContext();
        Context context = (aioContext == null || (c16 = aioContext.c()) == null) ? null : c16.getContext();
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", url);
        if (context != null) {
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(C2CRobotMsgHelper this$0, int i3, cmd0x934$RspBody cmd0x934_rspbody) {
        Fragment c16;
        Context context;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 0) {
            String qqStr = HardCodeUtil.qqStr(R.string.t2q);
            com.tencent.aio.api.runtime.a aioContext = this$0.getAioContext();
            if (aioContext == null || (c16 = aioContext.c()) == null || (context = c16.getContext()) == null) {
                return;
            }
            QQToast.makeText(context, 1, qqStr + ((Object) ""), 0).show();
        }
    }

    private final void o(String content) {
        Resources resources;
        QLog.i("C2CRobotMsgHelper", 1, "[sendRobotMsg] content:" + content);
        com.tencent.aio.api.runtime.a aioContext = getAioContext();
        if (aioContext != null) {
            Context context = aioContext.c().getContext();
            if (content.length() > ((context == null || (resources = context.getResources()) == null) ? Integer.MAX_VALUE : resources.getInteger(R.integer.f167165o))) {
                QQToast.makeText(context, R.string.her, 0).show();
            } else {
                aioContext.e().h(new InputRobotMsgIntent.SetSlashCmdToInputEdiText(content));
            }
        }
    }

    @Override // com.tencent.qqnt.aio.helper.BaseLifecycleHelper
    public void e(MsgIntent i3) {
        Intrinsics.checkNotNullParameter(i3, "i");
        if (i3 instanceof AIOLifeCycleEvent.OnNewIntent) {
            j();
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.E0;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "C2CRobotMsgHelper";
    }

    @Override // com.tencent.qqnt.aio.helper.BaseLifecycleHelper
    public ArrayList<String> a() {
        ArrayList<String> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(com.tencent.qqnt.aio.utils.j.f352301a.a(Reflection.getOrCreateKotlinClass(AIOLifeCycleEvent.OnNewIntent.class)));
        return arrayListOf;
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{3};
    }

    private final void j() {
        Bundle bundle;
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean startsWith$default3;
        int indexOf$default;
        AIOParam g16;
        com.tencent.aio.api.runtime.a aioContext = getAioContext();
        String str = null;
        Bundle l3 = (aioContext == null || (g16 = aioContext.g()) == null) ? null : g16.l();
        if (l3 == null || (bundle = l3.getBundle(AppConstants.Key.KEY_INVOKE_TROOP_ROBOT_FUNCTION)) == null) {
            return;
        }
        l3.remove(AppConstants.Key.KEY_INVOKE_TROOP_ROBOT_FUNCTION);
        String string = bundle.getString("robotuin");
        String string2 = bundle.getString("troopuin");
        String string3 = bundle.getString("offurl");
        String string4 = bundle.getString("offtitle");
        QLog.i("C2CRobotMsgHelper", 1, "[handleOnNewIntent] strRobotUin:" + StringUtil.getSimpleUinForPrint(string) + ",strTroopUin:" + string2 + ",strOffUrl:" + string3 + ",strOffTitle:" + string4);
        if (string4 == null || string4.length() == 0) {
            return;
        }
        RobotPanelLayoutBase.b a16 = RobotPanelLayoutBase.b.a("", "", string3, string4);
        String str2 = a16.f302401a.f302407c;
        Intrinsics.checkNotNullExpressionValue(str2, "itemData.offinfo.url");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str2, "inputKeyOp://sendToRobot", false, 2, null);
        if (startsWith$default) {
            String str3 = a16.f302401a.f302405a;
            Intrinsics.checkNotNullExpressionValue(str3, "itemData.offinfo.title");
            o(str3);
            return;
        }
        String str4 = a16.f302401a.f302407c;
        Intrinsics.checkNotNullExpressionValue(str4, "itemData.offinfo.url");
        startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(str4, "inputKeyOp://sendToBackEnd", false, 2, null);
        if (startsWith$default2) {
            String str5 = a16.f302401a.f302407c;
            Intrinsics.checkNotNullExpressionValue(str5, "itemData.offinfo.url");
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str5, "content=", 0, false, 6, (Object) null);
            if (indexOf$default > 0) {
                String str6 = a16.f302401a.f302407c;
                Intrinsics.checkNotNullExpressionValue(str6, "itemData.offinfo.url");
                str = str6.substring(indexOf$default + 8);
                Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).substring(startIndex)");
            }
            String str7 = a16.f302401a.f302405a;
            Intrinsics.checkNotNullExpressionValue(str7, "itemData.offinfo.title");
            o(str7);
            if (str != null) {
                m(string2, string, str);
                return;
            }
            return;
        }
        String str8 = a16.f302401a.f302407c;
        Intrinsics.checkNotNullExpressionValue(str8, "itemData.offinfo.url");
        startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(str8, "http", false, 2, null);
        if (startsWith$default3) {
            String str9 = a16.f302401a.f302407c;
            Intrinsics.checkNotNullExpressionValue(str9, "itemData.offinfo.url");
            k(str9);
            return;
        }
        QLog.i("C2CRobotMsgHelper", 1, "[handleOnNewIntent] illegal case");
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 3) {
            h();
        }
    }

    private final void m(String strTroopUin, String strRobotUin, String strContent) {
        if (strContent == null || strContent.length() == 0) {
            return;
        }
        if (strTroopUin == null || strTroopUin.length() == 0) {
            return;
        }
        if (strRobotUin == null || strRobotUin.length() == 0) {
            return;
        }
        try {
            long parseLong = Long.parseLong(strTroopUin);
            long parseLong2 = Long.parseLong(strRobotUin);
            ITroopRobotService.a aVar = new ITroopRobotService.a() { // from class: com.tencent.qqnt.aio.helper.ae
                @Override // com.tencent.mobileqq.troop.robot.api.ITroopRobotService.a
                public final void a(int i3, cmd0x934$RspBody cmd0x934_rspbody) {
                    C2CRobotMsgHelper.n(C2CRobotMsgHelper.this, i3, cmd0x934_rspbody);
                }
            };
            ITroopRobotService i3 = i();
            if (i3 != null) {
                if (Intrinsics.areEqual("1", strTroopUin)) {
                    i3.sendContent(parseLong2, strContent, aVar);
                } else {
                    i3.sendContent(parseLong, parseLong2, strContent, aVar);
                }
            }
        } catch (NumberFormatException unused) {
            QLog.e("C2CRobotMsgHelper", 1, "sendContent exception");
        }
    }
}
