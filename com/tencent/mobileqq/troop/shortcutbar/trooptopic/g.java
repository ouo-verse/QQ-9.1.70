package com.tencent.mobileqq.troop.shortcutbar.trooptopic;

import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;
import com.tencent.mobileqq.troop.topicrecommend.api.ITroopTopicRecommendApi;
import com.tencent.mobileqq.troop.utils.r;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.AppShortcutBarScrollView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.TopicAISubject;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0007*\u0002Xb\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0002&%B!\u0012\u0006\u00100\u001a\u00020.\u0012\b\u00103\u001a\u0004\u0018\u000101\u0012\u0006\u00106\u001a\u000204\u00a2\u0006\u0004\bf\u0010gJ \u0010\b\u001a\u00020\u00072\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\u0002J\u001a\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u0015\u001a\u00020\u0007H\u0002J\b\u0010\u0016\u001a\u00020\u0007H\u0002J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0018\u0010\u001b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0011H\u0002J\u001a\u0010 \u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002J\b\u0010!\u001a\u00020\u0007H\u0002J\u0006\u0010\"\u001a\u00020\u0007J\u0018\u0010%\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010$\u001a\u00020#H\u0016J\b\u0010&\u001a\u00020\u0007H\u0016J\"\u0010'\u001a\u00020\u00072\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005J\"\u0010(\u001a\u00020\u00072\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005J\u0006\u0010*\u001a\u00020)J\u0006\u0010+\u001a\u00020\u0007J\u0006\u0010,\u001a\u00020\u0007J\b\u0010-\u001a\u00020\u0007H\u0016R\u0014\u00100\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010/R\u0016\u00103\u001a\u0004\u0018\u0001018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u00102R\u0014\u00106\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010\u000e\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010B\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010(R\u0016\u0010E\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR$\u0010L\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u0014\u0010P\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010T\u001a\u00020Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010W\u001a\u00020U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010VR\u0014\u0010[\u001a\u00020X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010^\u001a\u00020\\8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010]R\u0016\u0010a\u001a\u0004\u0018\u00010\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0014\u0010e\u001a\u00020b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bc\u0010d\u00a8\u0006h"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcutbar/trooptopic/g;", "Lcom/tencent/mobileqq/troop/shortcutbar/b;", "Let2/a;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/troop/shortcutbar/ShortcutBarInfo;", "Lkotlin/collections/ArrayList;", "list", "", ReportConstant.COSTREPORT_PREFIX, "Landroid/view/View;", "view", "", "duration", "t", "root", "l", "B", "Lcom/tencent/qqnt/kernel/nativeinterface/TopicAISubject;", "aiSubject", BdhLogUtil.LogTag.Tag_Conn, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, UserInfo.SEX_FEMALE, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "r", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, DomainData.DOMAIN_NAME, "", "type", "", "itemId", "E", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "H", "Let2/b;", ParseCommon.CONTAINER, "b", "a", "K", "J", "", HippyTKDListViewAdapter.X, "w", "G", "c", "Lcom/tencent/mobileqq/activity/aio/rebuild/input/shortcutbar/a;", "Lcom/tencent/mobileqq/activity/aio/rebuild/input/shortcutbar/a;", "aioShortcutBarContext", "Lcom/tencent/mobileqq/widget/AppShortcutBarScrollView;", "Lcom/tencent/mobileqq/widget/AppShortcutBarScrollView;", "appShortcutBarView", "Lcom/tencent/mobileqq/activity/aio/helper/TroopAppShortcutBarHelper;", "Lcom/tencent/mobileqq/activity/aio/helper/TroopAppShortcutBarHelper;", "helper", "Lcom/tencent/mobileqq/troop/shortcutbar/trooptopic/TroopTopicRecommendData;", "d", "Lcom/tencent/mobileqq/troop/shortcutbar/trooptopic/TroopTopicRecommendData;", "troopTopicRecommendData", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "closeImage", "f", "Landroid/view/View;", "g", "defaultShowDuration", tl.h.F, "Z", "isShowTopicRecommend", "i", "Lcom/tencent/qqnt/kernel/nativeinterface/TopicAISubject;", "v", "()Lcom/tencent/qqnt/kernel/nativeinterface/TopicAISubject;", "setCurrentItem", "(Lcom/tencent/qqnt/kernel/nativeinterface/TopicAISubject;)V", "currentItem", "Lcom/tencent/util/MqqWeakReferenceHandler;", "j", "Lcom/tencent/util/MqqWeakReferenceHandler;", "mSubHandler", "Ljava/lang/Runnable;", "k", "Ljava/lang/Runnable;", "runnable", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnClickListener;", "onCloseClick", "com/tencent/mobileqq/troop/shortcutbar/trooptopic/g$c", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/troop/shortcutbar/trooptopic/g$c;", "configurationChangedCallback", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isRegistered", "o", "Ljava/lang/String;", "msgSendType", "com/tencent/mobileqq/troop/shortcutbar/trooptopic/g$d", "p", "Lcom/tencent/mobileqq/troop/shortcutbar/trooptopic/g$d;", "msgSendAction", "<init>", "(Lcom/tencent/mobileqq/activity/aio/rebuild/input/shortcutbar/a;Lcom/tencent/mobileqq/widget/AppShortcutBarScrollView;Lcom/tencent/mobileqq/activity/aio/helper/TroopAppShortcutBarHelper;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class g implements com.tencent.mobileqq.troop.shortcutbar.b, et2.a {
    static IPatchRedirector $redirector_;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.a aioShortcutBarContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final AppShortcutBarScrollView appShortcutBarView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TroopAppShortcutBarHelper helper;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TroopTopicRecommendData troopTopicRecommendData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView closeImage;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View root;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long defaultShowDuration;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isShowTopicRecommend;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TopicAISubject currentItem;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MqqWeakReferenceHandler mSubHandler;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable runnable;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View.OnClickListener onCloseClick;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c configurationChangedCallback;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean isRegistered;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String msgSendType;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d msgSendAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcutbar/trooptopic/g$a;", "", "", "BUSI_NAME", "Ljava/lang/String;", "ELEMENT_ID_CLOSE", "ELEMENT_ID_TEXT", "ELEMENT_PARAM_CONTENT", "ELEMENT_PARAM_DATA", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.shortcutbar.trooptopic.g$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcutbar/trooptopic/g$b;", "", "Landroid/widget/LinearLayout;", "a", "Landroid/widget/LinearLayout;", "()Landroid/widget/LinearLayout;", "c", "(Landroid/widget/LinearLayout;)V", "itemContent", "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "()Landroid/widget/TextView;", "d", "(Landroid/widget/TextView;)V", "itemTitle", "<init>", "(Lcom/tencent/mobileqq/troop/shortcutbar/trooptopic/g;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public LinearLayout itemContent;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public TextView itemTitle;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this);
            }
        }

        @NotNull
        public final LinearLayout a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (LinearLayout) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            LinearLayout linearLayout = this.itemContent;
            if (linearLayout != null) {
                return linearLayout;
            }
            Intrinsics.throwUninitializedPropertyAccessException("itemContent");
            return null;
        }

        @NotNull
        public final TextView b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (TextView) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            TextView textView = this.itemTitle;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("itemTitle");
            return null;
        }

        public final void c(@NotNull LinearLayout linearLayout) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) linearLayout);
            } else {
                Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
                this.itemContent = linearLayout;
            }
        }

        public final void d(@NotNull TextView textView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) textView);
            } else {
                Intrinsics.checkNotNullParameter(textView, "<set-?>");
                this.itemTitle = textView;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/troop/shortcutbar/trooptopic/g$c", "Lcom/tencent/aio/api/runtime/emitter/b;", "Landroid/content/res/Configuration;", "configuration", "", "onConfigurationChanged", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c implements com.tencent.aio.api.runtime.emitter.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this);
            }
        }

        @Override // com.tencent.aio.api.runtime.emitter.b
        public void onConfigurationChanged(@NotNull Configuration configuration) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) configuration);
            } else {
                Intrinsics.checkNotNullParameter(configuration, "configuration");
                g.this.H();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/troop/shortcutbar/trooptopic/g$d", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class d implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            AIOMsgSendEvent.OnMsgSendSuccessEvent onMsgSendSuccessEvent;
            String str;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
                return;
            }
            Intrinsics.checkNotNullParameter(i3, "i");
            if (i3 instanceof AIOMsgSendEvent.OnMsgSendSuccessEvent) {
                onMsgSendSuccessEvent = (AIOMsgSendEvent.OnMsgSendSuccessEvent) i3;
            } else {
                onMsgSendSuccessEvent = null;
            }
            if (onMsgSendSuccessEvent == null) {
                return;
            }
            QLog.d("TroopTopicRecommendBarPanel", 1, "call: successIntent result " + onMsgSendSuccessEvent);
            ArrayList<MsgElement> transformAioMsgToElements = ((IAIOMsgItemApi) QRoute.api(IAIOMsgItemApi.class)).transformAioMsgToElements(onMsgSendSuccessEvent.c().b());
            g gVar = g.this;
            for (MsgElement msgElement : transformAioMsgToElements) {
                if (msgElement.elementType == 1) {
                    String str3 = msgElement.textElement.content;
                    TopicAISubject v3 = gVar.v();
                    if (v3 != null) {
                        str = v3.content;
                    } else {
                        str = null;
                    }
                    if (Intrinsics.areEqual(str3, str)) {
                        gVar.G();
                        TopicAISubject v16 = gVar.v();
                        if (v16 != null) {
                            str2 = v16.itemId;
                        } else {
                            str2 = null;
                        }
                        gVar.E(2, str2);
                    }
                }
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return a.C9235a.a(this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62336);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public g(@NotNull com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.a aioShortcutBarContext, @Nullable AppShortcutBarScrollView appShortcutBarScrollView, @NotNull TroopAppShortcutBarHelper helper) {
        Intrinsics.checkNotNullParameter(aioShortcutBarContext, "aioShortcutBarContext");
        Intrinsics.checkNotNullParameter(helper, "helper");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aioShortcutBarContext, appShortcutBarScrollView, helper);
            return;
        }
        this.aioShortcutBarContext = aioShortcutBarContext;
        this.appShortcutBarView = appShortcutBarScrollView;
        this.helper = helper;
        this.defaultShowDuration = 15000L;
        this.mSubHandler = new MqqWeakReferenceHandler(ThreadManagerV2.getQQCommonThreadLooper(), null);
        this.runnable = new Runnable() { // from class: com.tencent.mobileqq.troop.shortcutbar.trooptopic.b
            @Override // java.lang.Runnable
            public final void run() {
                g.D(g.this);
            }
        };
        this.onCloseClick = new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.shortcutbar.trooptopic.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.y(g.this, view);
            }
        };
        this.configurationChangedCallback = new c();
        this.isRegistered = new AtomicBoolean(false);
        this.msgSendType = Reflection.getOrCreateKotlinClass(AIOMsgSendEvent.OnMsgSendSuccessEvent.class).getQualifiedName();
        this.msgSendAction = new d();
    }

    private final void A() {
        ml3.b b16;
        ml3.a a16;
        com.tencent.aio.api.runtime.a a17;
        com.tencent.mvi.base.route.j e16;
        if (this.isRegistered.compareAndSet(false, true) && (a17 = this.aioShortcutBarContext.a()) != null && (e16 = a17.e()) != null) {
            e16.d(this.msgSendType, this.msgSendAction);
        }
        com.tencent.aio.api.runtime.a a18 = this.aioShortcutBarContext.a();
        if (a18 != null && (b16 = a18.b()) != null && (a16 = b16.a(com.tencent.aio.api.runtime.emitter.b.class)) != null) {
            a16.a(this.configurationChangedCallback);
        }
    }

    private final void B(View view) {
        VideoReport.setElementId(view, "em_group_close_btn");
        VideoReport.reportEvent("dt_imp", view, null);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    private final void C(View view, TopicAISubject aiSubject) {
        VideoReport.setElementId(view, "em_group_topic_text");
        HashMap hashMap = new HashMap();
        String str = aiSubject.content;
        Intrinsics.checkNotNullExpressionValue(str, "aiSubject.content");
        hashMap.put("content", str);
        String str2 = aiSubject.reportData;
        Intrinsics.checkNotNullExpressionValue(str2, "aiSubject.reportData");
        hashMap.put("report_data", str2);
        VideoReport.setElementParams(view, hashMap);
        VideoReport.reportEvent("dt_imp", view, hashMap);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(g this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("TroopTopicRecommendBarPanel", 1, "show time end, remove ui");
        ImageView imageView = this$0.closeImage;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeImage");
            imageView = null;
        }
        this$0.q(imageView);
        this$0.E(4, null);
        this$0.G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(int type, String itemId) {
        com.tencent.mobileqq.troop.topicrecommend.a aVar = new com.tencent.mobileqq.troop.topicrecommend.a(null, 0, 0, null, null, 31, null);
        String f16 = this.aioShortcutBarContext.f();
        Intrinsics.checkNotNullExpressionValue(f16, "aioShortcutBarContext.peerUin");
        aVar.f(f16);
        aVar.j(type);
        TroopTopicRecommendData troopTopicRecommendData = this.troopTopicRecommendData;
        TroopTopicRecommendData troopTopicRecommendData2 = null;
        if (troopTopicRecommendData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopTopicRecommendData");
            troopTopicRecommendData = null;
        }
        aVar.i(troopTopicRecommendData.getSource());
        TroopTopicRecommendData troopTopicRecommendData3 = this.troopTopicRecommendData;
        if (troopTopicRecommendData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopTopicRecommendData");
        } else {
            troopTopicRecommendData2 = troopTopicRecommendData3;
        }
        aVar.h(troopTopicRecommendData2.getRecallId());
        if (itemId != null) {
            aVar.g(itemId);
        }
        ((ITroopTopicRecommendApi) QRoute.api(ITroopTopicRecommendApi.class)).topicFeedback(aVar);
    }

    private final void F() {
        this.mSubHandler.postDelayed(this.runnable, this.defaultShowDuration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(g this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.root;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            view = null;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = com.tencent.mobileqq.aio.utils.e.f194142a.d();
        }
        View view3 = this$0.root;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
        } else {
            view2 = view3;
        }
        view2.requestLayout();
    }

    private final void l(View root) {
        ((AppShortcutBarScrollView) root.findViewById(R.id.f100425sg)).setMove(true);
        LinearLayout topicView = (LinearLayout) root.findViewById(R.id.ju7);
        TextView textView = (TextView) root.findViewById(R.id.f100385sc);
        URLImageView uRLImageView = (URLImageView) root.findViewById(R.id.f100375sb);
        View findViewById = root.findViewById(R.id.f100365sa);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.topic_recommend_close)");
        ImageView imageView = (ImageView) findViewById;
        this.closeImage = imageView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeImage");
            imageView = null;
        }
        imageView.setOnClickListener(this.onCloseClick);
        TroopTopicRecommendData troopTopicRecommendData = this.troopTopicRecommendData;
        if (troopTopicRecommendData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopTopicRecommendData");
            troopTopicRecommendData = null;
        }
        String iconUrlDefault = troopTopicRecommendData.getIconUrlDefault();
        if (ThemeUtil.isDefaultNightTheme() || ThemeUtil.isVasDarkTheme()) {
            TroopTopicRecommendData troopTopicRecommendData2 = this.troopTopicRecommendData;
            if (troopTopicRecommendData2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopTopicRecommendData");
                troopTopicRecommendData2 = null;
            }
            iconUrlDefault = troopTopicRecommendData2.getIconUrlDark();
        }
        r.l(uRLImageView.getContext(), uRLImageView, iconUrlDefault, 16.0f, false);
        TroopTopicRecommendData troopTopicRecommendData3 = this.troopTopicRecommendData;
        if (troopTopicRecommendData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopTopicRecommendData");
            troopTopicRecommendData3 = null;
        }
        this.defaultShowDuration = troopTopicRecommendData3.getDisappearSeconds() * 1000;
        TroopTopicRecommendData troopTopicRecommendData4 = this.troopTopicRecommendData;
        if (troopTopicRecommendData4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopTopicRecommendData");
            troopTopicRecommendData4 = null;
        }
        textView.setText(troopTopicRecommendData4.getTitle());
        TroopTopicRecommendData troopTopicRecommendData5 = this.troopTopicRecommendData;
        if (troopTopicRecommendData5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopTopicRecommendData");
            troopTopicRecommendData5 = null;
        }
        for (TopicAISubject topicAISubject : troopTopicRecommendData5.getAiSubjects()) {
            Intrinsics.checkNotNullExpressionValue(topicView, "topicView");
            View r16 = r(topicView);
            topicView.addView(r16);
            n(r16, topicAISubject);
        }
        ImageView imageView3 = this.closeImage;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeImage");
        } else {
            imageView2 = imageView3;
        }
        imageView2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.shortcutbar.trooptopic.a
            @Override // java.lang.Runnable
            public final void run() {
                g.m(g.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(g this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = this$0.closeImage;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeImage");
            imageView = null;
        }
        this$0.B(imageView);
    }

    private final void n(final View view, final TopicAISubject item) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.shortcutbar.trooptopic.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                g.o(g.this, item, view2);
            }
        });
        Object tag = view.getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.troop.shortcutbar.trooptopic.TroopTopicRecommendBarPanel.ItemHolder");
        b bVar = (b) tag;
        bVar.a().setPadding(ViewUtils.dip2px(10.0f), 0, 0, 0);
        bVar.a().setBackgroundResource(R.drawable.qui_common_fill_light_secondary_round_8_bg_selector);
        bVar.b().setText(item.content);
        view.post(new Runnable() { // from class: com.tencent.mobileqq.troop.shortcutbar.trooptopic.f
            @Override // java.lang.Runnable
            public final void run() {
                g.p(g.this, view, item);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(g this$0, TopicAISubject item, View it) {
        com.tencent.mvi.base.route.j e16;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        com.tencent.aio.api.runtime.a a16 = this$0.aioShortcutBarContext.a();
        if (a16 != null && (e16 = a16.e()) != null) {
            String str = item.content;
            Intrinsics.checkNotNullExpressionValue(str, "item.content");
            e16.h(new AIOMsgSendEvent.TextSendEvent(str));
        }
        this$0.currentItem = item;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.q(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(g this$0, View view, TopicAISubject item) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.C(view, item);
    }

    private final void q(View view) {
        this.helper.u();
        this.helper.F(view);
    }

    private final View r(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bvm, (ViewGroup) null);
        b bVar = new b();
        if (view != null) {
            View findViewById = view.findViewById(R.id.ir7);
            Intrinsics.checkNotNullExpressionValue(findViewById, "it.findViewById(R.id.shortcut_app_item_content)");
            bVar.c((LinearLayout) findViewById);
            ((URLImageView) view.findViewById(R.id.ir8)).setVisibility(8);
            ((TextView) view.findViewById(R.id.irt)).setVisibility(8);
            View findViewById2 = view.findViewById(R.id.iru);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "it.findViewById(R.id.shortcut_app_item_title)");
            bVar.d((TextView) findViewById2);
        }
        view.setTag(bVar);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return view;
    }

    private final void s(ArrayList<ShortcutBarInfo> list) {
        View view = null;
        View inflate = View.inflate(this.aioShortcutBarContext.e(), R.layout.du9, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n            aio\u2026           null\n        )");
        this.root = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
        } else {
            view = inflate;
        }
        l(view);
    }

    private final void t(View view, long duration) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.2f, 1.0f);
        alphaAnimation.setDuration(duration);
        alphaAnimation.setFillAfter(true);
        view.startAnimation(alphaAnimation);
    }

    static /* synthetic */ void u(g gVar, View view, long j3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j3 = 480;
        }
        gVar.t(view, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(g this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(view, "view");
        this$0.q(view);
        this$0.E(3, null);
        this$0.G();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void z() {
        ml3.b b16;
        ml3.a a16;
        this.isShowTopicRecommend = false;
        this.mSubHandler.removeCallbacks(this.runnable);
        com.tencent.aio.api.runtime.a a17 = this.aioShortcutBarContext.a();
        if (a17 != null && (b16 = a17.b()) != null && (a16 = b16.a(com.tencent.aio.api.runtime.emitter.b.class)) != null) {
            a16.c(this.configurationChangedCallback);
        }
    }

    public final void G() {
        com.tencent.aio.api.runtime.a a16;
        com.tencent.mvi.base.route.j e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else if (this.isRegistered.compareAndSet(true, false) && (a16 = this.aioShortcutBarContext.a()) != null && (e16 = a16.e()) != null) {
            e16.b(this.msgSendType, this.msgSendAction);
        }
    }

    public final void H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        View view = this.root;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            view = null;
        }
        view.post(new Runnable() { // from class: com.tencent.mobileqq.troop.shortcutbar.trooptopic.d
            @Override // java.lang.Runnable
            public final void run() {
                g.I(g.this);
            }
        });
    }

    public final void J(@Nullable ArrayList<ShortcutBarInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) list);
            return;
        }
        if (list != null && list.size() > 0 && (list.get(0) instanceof TroopTopicRecommendData)) {
            ShortcutBarInfo shortcutBarInfo = list.get(0);
            Intrinsics.checkNotNull(shortcutBarInfo, "null cannot be cast to non-null type com.tencent.mobileqq.troop.shortcutbar.trooptopic.TroopTopicRecommendData");
            this.troopTopicRecommendData = (TroopTopicRecommendData) shortcutBarInfo;
            AppShortcutBarScrollView appShortcutBarScrollView = this.appShortcutBarView;
            if (appShortcutBarScrollView == null) {
                return;
            }
            A();
            View findViewById = appShortcutBarScrollView.findViewById(R.id.f223403g);
            Intrinsics.checkNotNullExpressionValue(findViewById, "appShortcutBarViewNonNul\u2026_messageandapp_shortcuts)");
            LinearLayout linearLayout = (LinearLayout) findViewById;
            View findViewById2 = linearLayout.findViewById(R.id.f223203e);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "barView.findViewById(R.id.panel_message_shortcuts)");
            View findViewById3 = linearLayout.findViewById(R.id.f223303f);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "barView.findViewById(R.i\u2026l_message_shortcuts_line)");
            View findViewById4 = linearLayout.findViewById(R.id.f166477h53);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "barView.findViewById(R.id.panel_app_shortcuts)");
            LinearLayout linearLayout2 = (LinearLayout) findViewById4;
            appShortcutBarScrollView.setMove(false);
            ((LinearLayout) findViewById2).removeAllViews();
            linearLayout2.removeAllViews();
            findViewById3.setVisibility(8);
            linearLayout.getLayoutParams().height = -2;
            linearLayout2.getLayoutParams().height = -2;
            s(list);
            View view = this.root;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("root");
                view = null;
            }
            linearLayout2.addView(view, new LinearLayout.LayoutParams(com.tencent.mobileqq.aio.utils.e.f194142a.d(), -2));
            u(this, linearLayout2, 0L, 2, null);
            this.isShowTopicRecommend = true;
            if (appShortcutBarScrollView.getVisibility() == 8) {
                this.helper.H();
            }
            F();
            E(1, null);
            return;
        }
        this.isShowTopicRecommend = false;
    }

    public final void K(@Nullable ArrayList<ShortcutBarInfo> list) {
        Integer num;
        Boolean bool;
        et2.b c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) list);
            return;
        }
        if (list != null) {
            num = Integer.valueOf(list.size());
        } else {
            num = null;
        }
        QLog.d("TroopTopicRecommendBarPanel", 1, "updateViewForNewShortcutBar:" + num);
        if (list != null && list.size() > 0 && (list.get(0) instanceof TroopTopicRecommendData)) {
            ShortcutBarInfo shortcutBarInfo = list.get(0);
            Intrinsics.checkNotNull(shortcutBarInfo, "null cannot be cast to non-null type com.tencent.mobileqq.troop.shortcutbar.trooptopic.TroopTopicRecommendData");
            this.troopTopicRecommendData = (TroopTopicRecommendData) shortcutBarInfo;
            A();
            s(list);
            F();
            et2.c cVar = this.helper.f178723r;
            if (cVar != null && (c16 = cVar.c()) != null) {
                bool = Boolean.valueOf(c16.b("topic"));
            } else {
                bool = null;
            }
            if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                E(1, null);
                return;
            }
            return;
        }
        this.isShowTopicRecommend = false;
    }

    @Override // et2.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // et2.a
    public void b(@NotNull ViewGroup parent, @NotNull et2.b container) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) parent, (Object) container);
            return;
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(container, "container");
        View view = this.root;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            view = null;
        }
        parent.addView(view, new LinearLayout.LayoutParams(com.tencent.mobileqq.aio.utils.e.f194142a.d(), -2));
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.b
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            this.isShowTopicRecommend = false;
            z();
        }
    }

    @Nullable
    public final TopicAISubject v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TopicAISubject) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.currentItem;
    }

    public final void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            z();
        }
    }

    public final boolean x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.isShowTopicRecommend;
    }
}
