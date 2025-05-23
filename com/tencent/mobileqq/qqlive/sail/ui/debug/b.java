package com.tencent.mobileqq.qqlive.sail.ui.debug;

import android.view.View;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.sail.model.common.UserInfo;
import com.tencent.mobileqq.qqlive.sail.room.f;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.liveroom.impl.room.audienceoperationbar.event.DebugClickBusEvent;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 -2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0014J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\u0012\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u0016\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0014\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00180\u0017H\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001bR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010&\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/debug/b;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/timi/game/liveroom/impl/room/audienceoperationbar/event/DebugClickBusEvent;", "", LocaleUtils.L_JAPANESE, "ia", "ha", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "getInitRelyViewStubId", "", "isPartEnable", "U9", "V9", "v", NodeProps.ON_CLICK, "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "e", "Landroid/view/View;", "containerView", "f", "btnClose", h.F, "btnCopy", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "roomInfoTextView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "watchInfoTextView", "", BdhLogUtil.LogTag.Tag_Conn, "J", "enterRoomTimeMs", "<init>", "()V", "D", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b extends com.tencent.mobileqq.qqlive.sail.base.c implements View.OnClickListener, SimpleEventReceiver<DebugClickBusEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private long enterRoomTimeMs;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View containerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View btnClose;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View btnCopy;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView roomInfoTextView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView watchInfoTextView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/debug/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.debug.b$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51729);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void ha() {
        View view = this.containerView;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private final void ia() {
        CharSequence charSequence;
        TextView textView = this.roomInfoTextView;
        CharSequence charSequence2 = null;
        if (textView != null) {
            charSequence = textView.getText();
        } else {
            charSequence = null;
        }
        TextView textView2 = this.watchInfoTextView;
        if (textView2 != null) {
            charSequence2 = textView2.getText();
        }
        com.tencent.timi.game.utils.a.a(getContext(), ((Object) charSequence) + "\n" + ((Object) charSequence2));
        QQToast.makeText(getContext(), "\u590d\u5236\u6210\u529f", 0, 0).show();
    }

    private final void ja() {
        String str;
        com.tencent.mobileqq.qqlive.sail.model.d b16;
        UserInfo j3;
        TextView textView = this.roomInfoTextView;
        if (textView != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("appId: " + QQLiveBusinessConfig.QQLIVE_APP_ID + "\n");
            sb5.append("roomId: " + H9() + "\n");
            sb5.append("\u4e3b\u64adUid: " + C9() + "\n");
            f F9 = F9();
            if (F9 != null && (b16 = F9.b()) != null && (j3 = b16.j()) != null) {
                str = j3.b();
            } else {
                str = null;
            }
            sb5.append("\u4e3b\u64adNick: " + str + "\n");
            textView.setText(sb5.toString());
        }
        TextView textView2 = this.watchInfoTextView;
        if (textView2 != null) {
            textView2.setText("\u5f00\u64ad\u65f6\u957f(ms):" + (System.currentTimeMillis() - this.enterRoomTimeMs));
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void U9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.U9();
        startInit();
        this.enterRoomTimeMs = System.currentTimeMillis();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.V9();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        this.enterRoomTimeMs = 0L;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<DebugClickBusEvent>> getEventClass() {
        ArrayList<Class<DebugClickBusEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(DebugClickBusEvent.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 9, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return R.id.f59492sv;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) v3);
        } else {
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.uez) {
                ha();
            } else if (num != null && num.intValue() == R.id.f164954uf0) {
                ia();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        View view;
        View view2;
        View view3;
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        TextView textView2 = null;
        if (rootView != null) {
            view = rootView.findViewById(R.id.f59492sv);
        } else {
            view = null;
        }
        this.containerView = view;
        if (view != null) {
            view.setVisibility(8);
        }
        if (rootView != null) {
            view2 = rootView.findViewById(R.id.uez);
        } else {
            view2 = null;
        }
        this.btnClose = view2;
        if (rootView != null) {
            view3 = rootView.findViewById(R.id.f164954uf0);
        } else {
            view3 = null;
        }
        this.btnCopy = view3;
        View view4 = this.btnClose;
        if (view4 != null) {
            view4.setOnClickListener(this);
        }
        View view5 = this.btnCopy;
        if (view5 != null) {
            view5.setOnClickListener(this);
        }
        if (rootView != null) {
            textView = (TextView) rootView.findViewById(R.id.f7809465);
        } else {
            textView = null;
        }
        this.roomInfoTextView = textView;
        if (rootView != null) {
            textView2 = (TextView) rootView.findViewById(R.id.f120667_6);
        }
        this.watchInfoTextView = textView2;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) event);
            return;
        }
        if ((event instanceof DebugClickBusEvent) && (view = this.containerView) != null) {
            if (view.getVisibility() == 8) {
                view.setVisibility(0);
                ja();
            } else {
                view.setVisibility(8);
            }
        }
    }
}
