package com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pic.api.IPicAIOApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.x;
import com.tencent.mobileqq.widget.listitem.ab;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.aio.adapter.api.IAIOJumpAction;
import com.tencent.qqnt.aio.gametail.api.IAIOGameTailApi;
import com.tencent.qqnt.aio.gametail.api.JumpType;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.QQConnectAttr;
import com.tencent.qqnt.msg.MsgExtKt;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0001!B\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR2\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012`\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/tailitem/ui/i;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/tailitem/ui/c;", "", "w", "Landroid/view/View;", "view", "y", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/data/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "o", NodeProps.ON_CLICK, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "H", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "I", "Ljava/util/HashMap;", "mReportParams", "Lcom/tencent/qqnt/aio/gametail/api/a;", "J", "Lcom/tencent/qqnt/aio/gametail/api/a;", "gameTailInfo", "itemView", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/ui/e;", "adapter", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/ui/e;)V", "K", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class i extends c {
    static IPatchRedirector $redirector_;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final int L;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private MsgRecord msgRecord;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private HashMap<String, Object> mReportParams;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.aio.gametail.api.a gameTailInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u0007\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/tailitem/ui/i$a;", "", "Landroid/content/Context;", "context", "Landroid/view/View;", "b", "", "iconWidth", "I", "a", "()I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui.i$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return i.L;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }

        @NotNull
        public final View b(@NotNull Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            ImageView imageView = new ImageView(context);
            imageView.setId(R.id.f165329vk2);
            Companion companion = i.INSTANCE;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(companion.a(), companion.a());
            layoutParams.gravity = 16;
            layoutParams.leftMargin = x.a(7.0f);
            imageView.setLayoutParams(layoutParams);
            TextView textView = new TextView(context);
            textView.setId(R.id.f165328vk1);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 16;
            layoutParams2.leftMargin = x.a(3.0f);
            layoutParams2.rightMargin = x.a(7.0f);
            textView.setMaxWidth(x.a(232.0f));
            textView.setLayoutParams(layoutParams2);
            textView.setTextSize(1, 12.0f);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setTextColor(ContextCompat.getColor(context, R.color.qui_common_text_secondary_light));
            textView.setMaxLines(1);
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setId(R.id.f165330vk3);
            linearLayout.setOrientation(0);
            ab.d(linearLayout, 8.0f);
            linearLayout.addView(imageView);
            linearLayout.addView(textView);
            return linearLayout;
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
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f191280a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62274);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[JumpType.values().length];
            try {
                iArr[JumpType.HTTP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[JumpType.SCHEMA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f191280a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62277);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
            L = x.a(12.0f);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NotNull View itemView, @NotNull com.tencent.mobileqq.aio.msglist.holder.component.msgtail.ui.e adapter) {
        super(itemView, adapter);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView, (Object) adapter);
        } else {
            this.mReportParams = new HashMap<>();
        }
    }

    private final void w() {
        com.tencent.qqnt.aio.gametail.api.a aVar = this.gameTailInfo;
        if (aVar != null) {
            this.mReportParams.put("gameAppid", Long.valueOf(aVar.a()));
            this.mReportParams.put("text_content", aVar.f());
            this.mReportParams.put("jump_link", aVar.e());
            this.mReportParams.put("background_color", aVar.b());
            this.mReportParams.put("dt_pgid", "pg_aio");
        }
    }

    private final void x(View view) {
        if (view != null) {
            VideoReport.setElementId(view, "em_bas_picture_tail");
            VideoReport.reportEvent("dt_clck", view, this.mReportParams);
        }
    }

    private final void y(final View view) {
        if (view != null) {
            view.post(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui.h
                @Override // java.lang.Runnable
                public final void run() {
                    i.z(i.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(i this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.w();
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementId(view, "em_bas_picture_tail");
        VideoReport.reportEvent("dt_imp", view, this$0.mReportParams);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui.c
    public void o(@NotNull com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.g item) {
        QQConnectAttr qQConnectAttr;
        com.tencent.qqnt.aio.gametail.api.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        View findViewById = this.itemView.findViewById(R.id.f165329vk2);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById<Im\u2026iew>(R.id.game_tail_icon)");
        ImageView imageView = (ImageView) findViewById;
        View findViewById2 = this.itemView.findViewById(R.id.f165328vk1);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById<Te\u2026iew>(R.id.game_tail_desc)");
        TextView textView = (TextView) findViewById2;
        MsgRecord a16 = item.a();
        this.msgRecord = a16;
        Long l3 = null;
        if (a16 != null) {
            qQConnectAttr = MsgExtKt.k(a16);
        } else {
            qQConnectAttr = null;
        }
        if (qQConnectAttr != null) {
            IAIOGameTailApi iAIOGameTailApi = (IAIOGameTailApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOGameTailApi.class);
            long j3 = qQConnectAttr.appID;
            int i3 = qQConnectAttr.appType;
            MsgRecord msgRecord = this.msgRecord;
            Intrinsics.checkNotNull(msgRecord);
            aVar = iAIOGameTailApi.getGamePicTailInfo(j3, i3, msgRecord.msgTime);
        } else {
            aVar = null;
        }
        this.gameTailInfo = aVar;
        MsgRecord msgRecord2 = this.msgRecord;
        if (msgRecord2 != null) {
            l3 = Long.valueOf(msgRecord2.msgId);
        }
        QLog.i("GameShareTailHolder", 1, "bindInner msgId:" + l3);
        if (this.gameTailInfo != null) {
            Drawable drawable = this.itemView.getContext().getDrawable(R.drawable.muz);
            IPicAIOApi iPicAIOApi = (IPicAIOApi) QRoute.api(IPicAIOApi.class);
            Option obtain = Option.obtain();
            com.tencent.qqnt.aio.gametail.api.a aVar2 = this.gameTailInfo;
            Intrinsics.checkNotNull(aVar2);
            obtain.setUrl(aVar2.c());
            obtain.setTargetView(imageView);
            obtain.setLoadingDrawable(drawable);
            obtain.setFailedDrawable(drawable);
            Intrinsics.checkNotNullExpressionValue(obtain, "obtain().apply {\n       \u2026rawable\n                }");
            iPicAIOApi.loadPic(obtain, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui.g
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(LoadState loadState, Option option) {
                    i.v(loadState, option);
                }
            });
            View view = this.itemView;
            com.tencent.qqnt.aio.gametail.api.a aVar3 = this.gameTailInfo;
            Intrinsics.checkNotNull(aVar3);
            view.setBackground(new ColorDrawable(Color.parseColor(aVar3.b())));
            com.tencent.qqnt.aio.gametail.api.a aVar4 = this.gameTailInfo;
            Intrinsics.checkNotNull(aVar4);
            textView.setText(aVar4.f());
            com.tencent.qqnt.aio.gametail.api.a aVar5 = this.gameTailInfo;
            Intrinsics.checkNotNull(aVar5);
            textView.setTextColor(Color.parseColor(aVar5.g()));
            y(textView);
            return;
        }
        QLog.i("GameShareTailHolder", 1, "getGamePicLittleTailInfo is null");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else {
            com.tencent.qqnt.aio.gametail.api.a aVar = this.gameTailInfo;
            if (aVar == null) {
                QLog.i("GameShareTailHolder", 1, "gameTailInfo is null");
            } else if (view == null) {
                QLog.i("GameShareTailHolder", 1, "view is null");
            } else {
                Intrinsics.checkNotNull(aVar);
                int i3 = b.f191280a[aVar.d().ordinal()];
                if (i3 != 1) {
                    if (i3 == 2) {
                        IAIOJumpAction iAIOJumpAction = (IAIOJumpAction) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOJumpAction.class);
                        Context context = view.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "view.context");
                        com.tencent.qqnt.aio.gametail.api.a aVar2 = this.gameTailInfo;
                        Intrinsics.checkNotNull(aVar2);
                        iAIOJumpAction.doUrlAction(context, aVar2.e());
                    }
                } else {
                    IAIOJumpAction iAIOJumpAction2 = (IAIOJumpAction) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOJumpAction.class);
                    Context context2 = view.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "view.context");
                    com.tencent.qqnt.aio.gametail.api.a aVar3 = this.gameTailInfo;
                    Intrinsics.checkNotNull(aVar3);
                    iAIOJumpAction2.openBrowser(context2, aVar3.e());
                }
                x(view);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(LoadState loadState, Option option) {
    }
}
