package com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.guild.api.IGuildEmotionCodecApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi;
import com.tencent.mobileqq.matchfriend.reborn.activity.QQStrangerPublicFragmentActivity;
import com.tencent.mobileqq.matchfriend.reborn.drag.DragViewProviderPriority;
import com.tencent.mobileqq.matchfriend.reborn.drag.QQStrangerDragLayoutPart;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadge;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0001,\u0018\u0000 22\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00013B\u0007\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0015\u001a\u00020\u0004J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\u001a\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00180\u0017j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0018`\u0019H\u0016R\u0016\u0010\u001d\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/QQStrangerLiteEntryPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "initView", "I9", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l;", "model", "K9", "H9", "", "unread", "Q9", "Landroid/content/Context;", "context", "", "event", "P9", "Landroid/view/View;", "L9", "M9", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "d", "Landroid/view/View;", "entryRootView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "summaryView", "f", "timeView", "Lcom/tencent/mobileqq/quibadge/QUIBadge;", tl.h.F, "Lcom/tencent/mobileqq/quibadge/QUIBadge;", "unreadView", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/e;", "i", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/e;", "dataCenter", "com/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/QQStrangerLiteEntryPart$b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/QQStrangerLiteEntryPart$b;", "priorityDragViewProvider", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerLiteEntryPart extends Part implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static QQStrangerLiteActionModel D;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View entryRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView summaryView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView timeView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QUIBadge unreadView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final e dataCenter = new e();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final b priorityDragViewProvider = new b();

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/QQStrangerLiteEntryPart$a;", "", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l;", "cacheModel", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l;", "getCacheModel", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l;", "a", "(Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l;)V", "", "DEFAULT_EMOJI_ID", "I", "", "SUMMARY_TEXT_HEIGHT", UserInfo.SEX_FEMALE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.QQStrangerLiteEntryPart$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(QQStrangerLiteActionModel qQStrangerLiteActionModel) {
            QQStrangerLiteEntryPart.D = qQStrangerLiteActionModel;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/QQStrangerLiteEntryPart$b", "Lcom/tencent/mobileqq/matchfriend/reborn/drag/a;", "Lcom/tencent/mobileqq/matchfriend/reborn/drag/DragViewProviderPriority;", "getPriority", "", "Landroid/view/View;", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b implements com.tencent.mobileqq.matchfriend.reborn.drag.a {
        b() {
        }

        @Override // com.tencent.mobileqq.matchfriend.reborn.drag.a
        public List<View> a() {
            ArrayList arrayList = new ArrayList();
            QQStrangerLiteEntryPart qQStrangerLiteEntryPart = QQStrangerLiteEntryPart.this;
            QUIBadge qUIBadge = qQStrangerLiteEntryPart.unreadView;
            QUIBadge qUIBadge2 = null;
            if (qUIBadge == null) {
                Intrinsics.throwUninitializedPropertyAccessException("unreadView");
                qUIBadge = null;
            }
            if (qUIBadge.isShown()) {
                QUIBadge qUIBadge3 = qQStrangerLiteEntryPart.unreadView;
                if (qUIBadge3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("unreadView");
                } else {
                    qUIBadge2 = qUIBadge3;
                }
                arrayList.add(qUIBadge2);
            }
            return arrayList;
        }

        @Override // com.tencent.mobileqq.matchfriend.reborn.drag.a
        public DragViewProviderPriority getPriority() {
            return DragViewProviderPriority.LITE_ACTION;
        }
    }

    private final void H9(QQStrangerLiteActionModel model) {
        QQText qQText = ((IGuildEmotionCodecApi) QRoute.api(IGuildEmotionCodecApi.class)).toQQText(model.getNick(), 16);
        int sceneId = model.getSceneId();
        if (sceneId == 6) {
            String str = ((Object) qQText) + " \u8d5e\u4e86\u4f60\u7684\u52a8\u6001";
            TextView textView = this.summaryView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("summaryView");
                textView = null;
            }
            textView.setText(str);
            TextView textView2 = this.summaryView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("summaryView");
                textView2 = null;
            }
            textView2.setCompoundDrawables(null, null, null, null);
            return;
        }
        if (sceneId == 7) {
            String str2 = ((Object) qQText) + " \u8bc4\u8bba\u4e86\u4f60\u7684\u52a8\u6001";
            TextView textView3 = this.summaryView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("summaryView");
                textView3 = null;
            }
            textView3.setText(str2);
            TextView textView4 = this.summaryView;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("summaryView");
                textView4 = null;
            }
            textView4.setCompoundDrawables(null, null, null, null);
            return;
        }
        if (sceneId != 8) {
            if (model.getCanChat()) {
                String str3 = ((Object) qQText) + " \u56de\u5e94\u4e86\u4f60\u7684\u540c\u9891\u4e92\u52a8";
                TextView textView5 = this.summaryView;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("summaryView");
                    textView5 = null;
                }
                textView5.setText(str3);
                TextView textView6 = this.summaryView;
                if (textView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("summaryView");
                    textView6 = null;
                }
                textView6.setCompoundDrawables(null, null, null, null);
                return;
            }
            String str4 = ((Object) qQText) + " \u7ed9\u4f60\u53d1\u9001\u4e86\u4e00\u4e2a";
            TextView textView7 = this.summaryView;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("summaryView");
                textView7 = null;
            }
            textView7.setText(str4);
            int convertToLocal = QQSysFaceUtil.convertToLocal(model.getEmojiId());
            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101845", false);
            if (QLog.isColorLevel()) {
                QLog.d("QQStrangerLiteEntryPart", 2, "getDefaultDrawableSwitch " + isSwitchOn);
            }
            if (convertToLocal == -1 && isSwitchOn) {
                convertToLocal = 49;
            }
            Drawable faceDrawable = QQSysFaceUtil.getFaceDrawable(convertToLocal);
            faceDrawable.setBounds(0, 0, cx.k(20.0f), cx.k(20.0f));
            TextView textView8 = this.summaryView;
            if (textView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("summaryView");
                textView8 = null;
            }
            textView8.setCompoundDrawables(null, null, faceDrawable, null);
            return;
        }
        String str5 = ((Object) qQText) + " \u56de\u590d\u4e86\u4f60\u7684\u8bc4\u8bba";
        TextView textView9 = this.summaryView;
        if (textView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("summaryView");
            textView9 = null;
        }
        textView9.setText(str5);
        TextView textView10 = this.summaryView;
        if (textView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("summaryView");
            textView10 = null;
        }
        textView10.setCompoundDrawables(null, null, null, null);
    }

    private final void I9() {
        Q9(q.f244623a.d());
        if (com.tencent.mobileqq.matchfriend.reborn.utils.h.c()) {
            View view = this.entryRootView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("entryRootView");
                view = null;
            }
            view.setVisibility(0);
        }
        QQStrangerLiteActionModel qQStrangerLiteActionModel = D;
        if (qQStrangerLiteActionModel != null) {
            K9(qQStrangerLiteActionModel);
        }
        this.dataCenter.q(new Function3<ArrayList<QQStrangerLiteActionModel>, Boolean, Boolean, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.QQStrangerLiteEntryPart$initEntryData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(ArrayList<QQStrangerLiteActionModel> arrayList, Boolean bool, Boolean bool2) {
                invoke(arrayList, bool.booleanValue(), bool2.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(ArrayList<QQStrangerLiteActionModel> list, boolean z16, boolean z17) {
                TextView textView;
                TextView textView2;
                TextView textView3;
                e eVar;
                Intrinsics.checkNotNullParameter(list, "list");
                if (list.isEmpty()) {
                    QQStrangerLiteEntryPart.INSTANCE.a(null);
                    textView = QQStrangerLiteEntryPart.this.summaryView;
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("summaryView");
                        textView = null;
                    }
                    textView.setText("");
                    textView2 = QQStrangerLiteEntryPart.this.summaryView;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("summaryView");
                        textView2 = null;
                    }
                    textView2.setCompoundDrawables(null, null, null, null);
                    textView3 = QQStrangerLiteEntryPart.this.timeView;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("timeView");
                        textView3 = null;
                    }
                    textView3.setText("");
                    eVar = QQStrangerLiteEntryPart.this.dataCenter;
                    e.v(eVar, false, null, 3, null);
                    return;
                }
                QQStrangerLiteEntryPart.INSTANCE.a(list.get(0));
                QQStrangerLiteEntryPart qQStrangerLiteEntryPart = QQStrangerLiteEntryPart.this;
                QQStrangerLiteActionModel qQStrangerLiteActionModel2 = list.get(0);
                Intrinsics.checkNotNullExpressionValue(qQStrangerLiteActionModel2, "list[0]");
                qQStrangerLiteEntryPart.K9(qQStrangerLiteActionModel2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(QQStrangerLiteEntryPart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = view.getContext();
        if (context != null) {
            this$0.P9(context, "dt_clck");
            QQStrangerPublicFragmentActivity.INSTANCE.a(context, new Intent(), QQStrangerLiteActionFragment.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K9(QQStrangerLiteActionModel model) {
        com.tencent.mobileqq.matchfriend.reborn.utils.h.u();
        View view = this.entryRootView;
        TextView textView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entryRootView");
            view = null;
        }
        view.setVisibility(0);
        H9(model);
        TextView textView2 = this.timeView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timeView");
        } else {
            textView = textView2;
        }
        textView.setText(model.getTime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(QQStrangerLiteEntryPart this$0, SimpleBaseEvent simpleBaseEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.entryRootView;
        TextView textView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entryRootView");
            view = null;
        }
        view.setVisibility(0);
        QQStrangerLiteActionModel data = ((QQStrangerLiteActionPushEvent) simpleBaseEvent).getData();
        D = data;
        e.n(this$0.dataCenter, data, false, 2, null);
        this$0.Q9(q.f244623a.d());
        this$0.H9(data);
        TextView textView2 = this$0.timeView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timeView");
        } else {
            textView = textView2;
        }
        textView.setText(data.getTime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(QQStrangerLiteEntryPart this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Q9(i3);
    }

    private final void P9(Context context, String event) {
        com.tencent.mobileqq.matchfriend.utils.d dVar = new com.tencent.mobileqq.matchfriend.utils.d(context);
        HashMap hashMap = new HashMap();
        hashMap.put("kl_new_from_openid", ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).getSelfOpenId());
        dVar.c("pg_kl_new_chat_list", hashMap);
        ArrayList arrayList = new ArrayList();
        arrayList.add("em_bas_interactive_notification_entry");
        dVar.b(arrayList);
        if (Intrinsics.areEqual(event, "dt_imp")) {
            dVar.f("em_bas_interactive_notification_entry");
        } else if (Intrinsics.areEqual(event, "dt_clck")) {
            dVar.d("em_bas_interactive_notification_entry");
        }
    }

    private final void Q9(int unread) {
        QUIBadge qUIBadge = this.unreadView;
        QUIBadge qUIBadge2 = null;
        if (qUIBadge == null) {
            Intrinsics.throwUninitializedPropertyAccessException("unreadView");
            qUIBadge = null;
        }
        qUIBadge.setRedNum(unread);
        QUIBadge qUIBadge3 = this.unreadView;
        if (qUIBadge3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("unreadView");
        } else {
            qUIBadge2 = qUIBadge3;
        }
        Boolean valueOf = Boolean.valueOf(unread <= 0);
        qUIBadge2.setVisibility(8);
        if (((View) au.a(valueOf, qUIBadge2)) == null) {
            qUIBadge2.setVisibility(0);
        }
    }

    private final void initView() {
        View view = this.entryRootView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entryRootView");
            view = null;
        }
        View findViewById = view.findViewById(R.id.oo5);
        Intrinsics.checkNotNullExpressionValue(findViewById, "entryRootView.findViewBy\u2026anger_lite_entry_summary)");
        this.summaryView = (TextView) findViewById;
        View view3 = this.entryRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entryRootView");
            view3 = null;
        }
        View findViewById2 = view3.findViewById(R.id.oo6);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "entryRootView.findViewBy\u2026stranger_lite_entry_time)");
        this.timeView = (TextView) findViewById2;
        View view4 = this.entryRootView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entryRootView");
            view4 = null;
        }
        View findViewById3 = view4.findViewById(R.id.f163170oo4);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "entryRootView.findViewBy\u2026ranger_lite_entry_reddot)");
        this.unreadView = (QUIBadge) findViewById3;
        View view5 = this.entryRootView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entryRootView");
        } else {
            view2 = view5;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view6) {
                QQStrangerLiteEntryPart.J9(QQStrangerLiteEntryPart.this, view6);
            }
        });
        I9();
    }

    public final View L9(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(context).inflate(R.layout.cxc, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026_action_entry_item, null)");
        this.entryRootView = inflate;
        initView();
        QQStrangerDragLayoutPart.INSTANCE.a(this.priorityDragViewProvider);
        SimpleEventBus.getInstance().registerReceiver(this);
        P9(context, "dt_imp");
        View view = this.entryRootView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("entryRootView");
        return null;
    }

    public final void M9() {
        QQStrangerDragLayoutPart.INSTANCE.b(this.priorityDragViewProvider);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QQStrangerLiteActionPushEvent.class);
        arrayList.add(QQStrangerLiteActionUnreadUpdateEvent.class);
        arrayList.add(QQStrangerLiteActionDeleteEvent.class);
        arrayList.add(QQStrangerLiteActionUnreadCleanUpEvent.class);
        arrayList.add(QQStrangerLiteActionPullAllEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(final SimpleBaseEvent event) {
        if (event instanceof QQStrangerLiteActionPushEvent) {
            com.tencent.mobileqq.matchfriend.reborn.utils.h.u();
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.r
                @Override // java.lang.Runnable
                public final void run() {
                    QQStrangerLiteEntryPart.N9(QQStrangerLiteEntryPart.this, event);
                }
            });
            return;
        }
        TextView textView = null;
        TextView textView2 = null;
        if (event instanceof QQStrangerLiteActionUnreadUpdateEvent) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if ((peekAppRuntime instanceof BaseQQAppInterface ? (BaseQQAppInterface) peekAppRuntime : null) != null) {
                final int d16 = com.tencent.mobileqq.matchfriend.reborn.utils.h.d();
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQStrangerLiteEntryPart.O9(QQStrangerLiteEntryPart.this, d16);
                    }
                });
                return;
            }
            return;
        }
        if (event instanceof QQStrangerLiteActionDeleteEvent) {
            ArrayList<QQStrangerLiteActionModel> f16 = this.dataCenter.f(((QQStrangerLiteActionDeleteEvent) event).getPosition());
            if (f16.isEmpty()) {
                D = null;
                QUIBadge qUIBadge = this.unreadView;
                if (qUIBadge == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("unreadView");
                    qUIBadge = null;
                }
                qUIBadge.setVisibility(8);
                TextView textView3 = this.summaryView;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("summaryView");
                    textView3 = null;
                }
                textView3.setText("");
                TextView textView4 = this.summaryView;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("summaryView");
                    textView4 = null;
                }
                textView4.setCompoundDrawables(null, null, null, null);
                TextView textView5 = this.timeView;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("timeView");
                } else {
                    textView2 = textView5;
                }
                textView2.setText("");
                return;
            }
            QQStrangerLiteActionModel qQStrangerLiteActionModel = f16.get(0);
            Intrinsics.checkNotNullExpressionValue(qQStrangerLiteActionModel, "it[0]");
            QQStrangerLiteActionModel qQStrangerLiteActionModel2 = qQStrangerLiteActionModel;
            D = qQStrangerLiteActionModel2;
            Q9(q.f244623a.d());
            H9(qQStrangerLiteActionModel2);
            TextView textView6 = this.timeView;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timeView");
            } else {
                textView = textView6;
            }
            textView.setText(qQStrangerLiteActionModel2.getTime());
            return;
        }
        if (event instanceof QQStrangerLiteActionUnreadCleanUpEvent) {
            QQStrangerLiteActionUnreadCleanUpEvent qQStrangerLiteActionUnreadCleanUpEvent = (QQStrangerLiteActionUnreadCleanUpEvent) event;
            this.dataCenter.u(qQStrangerLiteActionUnreadCleanUpEvent.getNotifyUI(), qQStrangerLiteActionUnreadCleanUpEvent.getCb());
        } else if (event instanceof QQStrangerLiteActionPullAllEvent) {
            QQStrangerLiteActionPullAllEvent qQStrangerLiteActionPullAllEvent = (QQStrangerLiteActionPullAllEvent) event;
            if (!qQStrangerLiteActionPullAllEvent.getModels().isEmpty()) {
                this.dataCenter.x(new ArrayList<>(qQStrangerLiteActionPullAllEvent.getModels()));
                D = qQStrangerLiteActionPullAllEvent.getModels().get(0);
                QQStrangerLiteActionModel qQStrangerLiteActionModel3 = qQStrangerLiteActionPullAllEvent.getModels().get(0);
                Intrinsics.checkNotNullExpressionValue(qQStrangerLiteActionModel3, "event.models[0]");
                K9(qQStrangerLiteActionModel3);
            }
        }
    }
}
