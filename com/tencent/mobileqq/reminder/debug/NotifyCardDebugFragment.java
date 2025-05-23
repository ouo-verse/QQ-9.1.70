package com.tencent.mobileqq.reminder.debug;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.cardcontainer.data.CardType;
import com.tencent.mobileqq.cardcontainer.data.ContainerData;
import com.tencent.mobileqq.cardcontainer.e;
import com.tencent.mobileqq.cardcontainer.f;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.reminder.api.IQQReminderBlessingApi;
import com.tencent.mobileqq.reminder.util.QQReminderUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 G2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001HB\u0007\u00a2\u0006\u0004\bE\u0010FJ\u0010\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0002J\u0010\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\u001a\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u000bH\u0016J,\u0010 \u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010!\u001a\u00020\u000bH\u0016J\u0010\u0010#\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u0007H\u0016J\u0012\u0010%\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010'\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u00132\b\u0010$\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010(\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u0007H\u0016R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00106\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010/R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u001b\u0010@\u001a\u00020;8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u001b\u0010D\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bA\u0010=\u001a\u0004\bB\u0010C\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/reminder/debug/NotifyCardDebugFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Lcm2/c;", "Lcom/tencent/mobileqq/cardcontainer/e;", "", "", "yh", "", OcrConfig.CHINESE, "", "isMain", "", "th", "Lcom/tencent/mobileqq/cardcontainer/data/ContainerData;", "uh", "vh", "Landroid/content/Context;", "context", "Eh", "", "getContentLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "isSuccess", "code", "msg", "", "data", "i", "F8", ZPlanPublishSource.FROM_SCHEME, "aa", "customReportData", "Ie", "clickPosition", "nc", com.tencent.bugly.common.constants.Constants.MMCCID, "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "mResTextView", "Landroid/widget/EditText;", "D", "Landroid/widget/EditText;", "mInput", "Landroid/view/ViewGroup;", "E", "Landroid/view/ViewGroup;", "mCardContainer", UserInfo.SEX_FEMALE, "mUserCntEditText", "Lcom/tencent/mobileqq/cardcontainer/d;", "G", "Lcom/tencent/mobileqq/cardcontainer/d;", "mNotifyCard", "Lcom/tencent/mobileqq/reminder/chats/notifycard/provider/a;", "H", "Lkotlin/Lazy;", "xh", "()Lcom/tencent/mobileqq/reminder/chats/notifycard/provider/a;", "mProvider", "I", "wh", "()J", "mNotifyTime", "<init>", "()V", "J", "a", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class NotifyCardDebugFragment extends QIphoneTitleBarFragment implements cm2.c, e {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TextView mResTextView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private EditText mInput;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ViewGroup mCardContainer;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private EditText mUserCntEditText;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.cardcontainer.d mNotifyCard;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy mProvider;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy mNotifyTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/reminder/debug/NotifyCardDebugFragment$a;", "", "", "SECONDS_PER_DAY", "I", "<init>", "()V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.reminder.debug.NotifyCardDebugFragment$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28798);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public NotifyCardDebugFragment() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(NotifyCardDebugFragment$mProvider$2.INSTANCE);
            this.mProvider = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(NotifyCardDebugFragment$mNotifyTime$2.INSTANCE);
            this.mNotifyTime = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(NotifyCardDebugFragment this$0, View view) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<Long> yh5 = this$0.yh();
        List<Long> list = yh5;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            TextView textView = this$0.mResTextView;
            if (textView != null) {
                textView.setText("uin\u6570\u7ec4\u975e\u6cd5");
            }
        } else {
            ((IQQReminderBlessingApi) QRoute.api(IQQReminderBlessingApi.class)).sendBlessingTimedMessage(yh5, 2, this$0);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bh(NotifyCardDebugFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.th(false);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(NotifyCardDebugFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.th(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dh(NotifyCardDebugFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getActivity();
        if (context == null) {
            context = view.getContext();
        }
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this$0.Eh(context);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Eh(Context context) {
        boolean z16;
        List<String> zh5 = zh();
        List<String> list = zh5;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        com.tencent.mobileqq.reminder.util.c.INSTANCE.e(context, new com.tencent.mobileqq.reminder.multishare.config.a(zh5, "\u6d4b\u8bd5", false, null, 8, null));
    }

    private final void th(boolean isMain) {
        ContainerData uh5;
        CardType cardType;
        com.tencent.mobileqq.reminder.chats.notifycard.view.a aVar;
        com.tencent.mobileqq.cardcontainer.d dVar = this.mNotifyCard;
        View view = null;
        if (dVar instanceof com.tencent.mobileqq.reminder.chats.notifycard.view.a) {
            if (dVar instanceof com.tencent.mobileqq.reminder.chats.notifycard.view.a) {
                aVar = (com.tencent.mobileqq.reminder.chats.notifycard.view.a) dVar;
            } else {
                aVar = null;
            }
            if (aVar != null) {
                aVar.c(false);
            }
        } else {
            F8();
        }
        ViewGroup viewGroup = this.mCardContainer;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        if (this.mCardContainer == null) {
            return;
        }
        if (isMain) {
            uh5 = vh();
        } else {
            uh5 = uh();
        }
        f c16 = xh().c();
        if (isMain) {
            cardType = CardType.SelfGroupMsgReminder;
        } else {
            cardType = CardType.GroupMsgReminder;
        }
        ViewGroup viewGroup2 = this.mCardContainer;
        Intrinsics.checkNotNull(viewGroup2);
        com.tencent.mobileqq.cardcontainer.d a16 = c16.a(cardType, viewGroup2);
        this.mNotifyCard = a16;
        ViewGroup viewGroup3 = this.mCardContainer;
        if (viewGroup3 != null) {
            if (a16 != null) {
                view = a16.getView();
            }
            viewGroup3.addView(view);
        }
        com.tencent.mobileqq.cardcontainer.d dVar2 = this.mNotifyCard;
        if (dVar2 != null) {
            dVar2.d(uh5, this);
        }
    }

    private final ContainerData uh() {
        Editable editable;
        Integer intOrNull;
        int i3;
        int i16;
        String str;
        String str2;
        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        ArrayList arrayList = new ArrayList();
        EditText editText = this.mUserCntEditText;
        if (editText != null) {
            editable = editText.getText();
        } else {
            editable = null;
        }
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(String.valueOf(editable));
        if (intOrNull != null) {
            i3 = intOrNull.intValue();
        } else {
            i3 = 1;
        }
        if (i3 <= 0) {
            i16 = 1;
        } else if (i3 > 4) {
            i16 = 4;
        } else {
            i16 = i3;
        }
        int i17 = 0;
        while (i17 < i16) {
            arrayList.add(new com.tencent.mobileqq.cardcontainer.data.b(String.valueOf(i17), currentUin, null, null, null, null, "{\"birthday\":" + (wh() + (86400 * i17)) + ", \"uin\":" + currentUin + "}", ""));
            i17++;
            i16 = i16;
        }
        int i18 = i16;
        int n3 = QQReminderUtil.n(NetConnInfoCenter.getServerTimeMillis());
        com.tencent.mobileqq.reminder.chats.notifycard.provider.a xh5 = xh();
        CardType cardType = CardType.GroupMsgReminder;
        if (i18 == 1) {
            str = "\u7684\u751f\u65e5";
        } else {
            str = QzoneConfig.DefaultValue.USERHOME_BAR_NAME;
        }
        if (i18 == 1) {
            str2 = "\u597d\u53cb\u5373\u5c06\u751f\u65e5";
        } else {
            str2 = "\u795d\u798f\u4f1a\u5728\u751f\u65e5\u5f53\u5929\u4e0a\u534810:00\u9001\u8fbe";
        }
        return xh5.a(new ContainerData(0, cardType, "", "https://tangram-1251316161.file.myqcloud.com/files/20241118/767ffe66bc519dd411e0745e123c11d7.png", str, "", arrayList, "{\"button\": {\"text\":\"\u4e00\u952e\u751f\u65e5\u795d\u798f\",\"iconUrl\":\"\",\"backgroundUrl\": \"https://tangram-1251316161.file.myqcloud.com/files/20241114/8071f64928dcbb5bc1f9cb773ee4674a.png\"},    \"headBgUrl\" : \"https://tangram-1251316161.file.myqcloud.com/files/20241114/d612e6c1a782e6f0944583883f2e0cf6.png\",\n    \"headPendantUrl\" : \"https://tangram-1251316161.file.myqcloud.com/files/20241114/8e8920dd12b5739123612625426d0d5b.png\",\n\"boxSubTitle\":\"" + str2 + "\",\"dataDate\":" + n3 + "}", ""));
    }

    private final ContainerData vh() {
        Editable editable;
        Integer intOrNull;
        int i3;
        int i16;
        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        ArrayList arrayList = new ArrayList();
        EditText editText = this.mUserCntEditText;
        if (editText != null) {
            editable = editText.getText();
        } else {
            editable = null;
        }
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(String.valueOf(editable));
        if (intOrNull != null) {
            i3 = intOrNull.intValue();
        } else {
            i3 = 1;
        }
        if (i3 <= 0) {
            i16 = 1;
        } else {
            i16 = i3;
        }
        for (int i17 = 0; i17 < i16; i17++) {
            arrayList.add(new com.tencent.mobileqq.cardcontainer.data.b(String.valueOf(i17), currentUin, null, null, null, null, null, ""));
        }
        int n3 = QQReminderUtil.n(NetConnInfoCenter.getServerTimeMillis());
        return xh().a(new ContainerData(0, CardType.SelfGroupMsgReminder, "", "https://tangram-1251316161.file.myqcloud.com/files/20241118/767ffe66bc519dd411e0745e123c11d7.png", "\uff0c\u751f\u65e5\u5feb\u4e50\uff01", i16 + "\u4f4d\u597d\u53cb\u7ed9\u4f60\u53d1\u4e86\u751f\u65e5\u795d\u798f", arrayList, "{\n    \"nick\": \"Test\",\n    \"actionButtonList\": [{\n    \"text\": \"\u4e00\u952e\u7b54\u8c22\",\n    \"jumpUrl\": \"\"\n}],\n    \"headBgUrl\" : \"https://tangram-1251316161.file.myqcloud.com/files/20240926/3fd3861009e6659028ae06af40b8e853.png\",\n    \"headPendantUrl\" : \"https://tangram-1251316161.file.myqcloud.com/files/20240926/8205da4c89048870e7279f9695290d46.png\",\n    \"dataDate\": " + n3 + "\n}", ""));
    }

    private final long wh() {
        return ((Number) this.mNotifyTime.getValue()).longValue();
    }

    private final com.tencent.mobileqq.reminder.chats.notifycard.provider.a xh() {
        return (com.tencent.mobileqq.reminder.chats.notifycard.provider.a) this.mProvider.getValue();
    }

    private final List<Long> yh() {
        Editable text;
        String obj;
        boolean z16;
        List split$default;
        Long longOrNull;
        EditText editText = this.mInput;
        ArrayList arrayList = null;
        if (editText != null && (text = editText.getText()) != null && (obj = text.toString()) != null) {
            if (obj.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return null;
            }
            split$default = StringsKt__StringsKt.split$default((CharSequence) obj, new String[]{","}, false, 0, 6, (Object) null);
            arrayList = new ArrayList();
            Iterator it = split$default.iterator();
            while (it.hasNext()) {
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull((String) it.next());
                if (longOrNull != null) {
                    arrayList.add(longOrNull);
                }
            }
        }
        return arrayList;
    }

    private final List<String> zh() {
        Editable text;
        String obj;
        boolean z16;
        List<String> split$default;
        EditText editText = this.mInput;
        if (editText == null || (text = editText.getText()) == null || (obj = text.toString()) == null) {
            return null;
        }
        if (obj.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return null;
        }
        split$default = StringsKt__StringsKt.split$default((CharSequence) obj, new String[]{","}, false, 0, 6, (Object) null);
        return split$default;
    }

    @Override // com.tencent.mobileqq.cardcontainer.e
    public void F8() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        ViewGroup viewGroup = this.mCardContainer;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        ViewGroup viewGroup2 = this.mCardContainer;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.e
    public void G2(@Nullable String customReportData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) customReportData);
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.e
    public void Ie(@Nullable String customReportData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) customReportData);
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.e
    public void aa(@NotNull String scheme) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) scheme);
        } else {
            Intrinsics.checkNotNullParameter(scheme, "scheme");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.fen;
    }

    @Override // cm2.b
    public void i(boolean isSuccess, int code, @Nullable String msg2, @Nullable Object data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(isSuccess), Integer.valueOf(code), msg2, data);
            return;
        }
        TextView textView = this.mResTextView;
        if (textView != null) {
            textView.setText("isSuccess: " + isSuccess + " code: " + code + " msg: " + msg2);
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.e
    public void nc(int clickPosition, @Nullable String customReportData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, clickPosition, (Object) customReportData);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onDestroy();
        com.tencent.mobileqq.cardcontainer.d dVar = this.mNotifyCard;
        if (dVar != null) {
            dVar.b();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setTitle("\u63d0\u9192\u5361\u7247\u6d4b\u8bd5");
        this.mInput = (EditText) view.findViewById(R.id.zur);
        this.mResTextView = (TextView) view.findViewById(R.id.zun);
        this.mCardContainer = (ViewGroup) view.findViewById(R.id.zul);
        this.mUserCntEditText = (EditText) view.findViewById(R.id.zum);
        view.findViewById(R.id.zup).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.reminder.debug.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NotifyCardDebugFragment.Ah(NotifyCardDebugFragment.this, view2);
            }
        });
        view.findViewById(R.id.zuk).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.reminder.debug.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NotifyCardDebugFragment.Bh(NotifyCardDebugFragment.this, view2);
            }
        });
        view.findViewById(R.id.zuj).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.reminder.debug.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NotifyCardDebugFragment.Ch(NotifyCardDebugFragment.this, view2);
            }
        });
        view.findViewById(R.id.zuq).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.reminder.debug.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NotifyCardDebugFragment.Dh(NotifyCardDebugFragment.this, view2);
            }
        });
    }
}
