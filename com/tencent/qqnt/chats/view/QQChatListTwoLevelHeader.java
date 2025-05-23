package com.tencent.qqnt.chats.view;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qqnt.widget.smartrefreshlayout.header.ExtTwoLevelHeader;
import com.qqnt.widget.smartrefreshlayout.header.TwoLevelHeader;
import com.qqnt.widget.smartrefreshlayout.layout.constant.RefreshState;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.hippy.qq.view.scroll.HippyHeaderScrollViewController;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.view.QQChatListTwoLevelHeader;
import com.tencent.qqnt.chats.view.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0002CDB\u0011\b\u0016\u0012\u0006\u0010<\u001a\u00020;\u00a2\u0006\u0004\b=\u0010>B\u001b\b\u0016\u0012\u0006\u0010<\u001a\u00020;\u0012\b\u0010@\u001a\u0004\u0018\u00010?\u00a2\u0006\u0004\b=\u0010AJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0012\u0010\t\u001a\u00020\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J \u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J:\u0010\u0018\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\u0016\u0010\u001b\u001a\u00020\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019H\u0004R\u0017\u0010!\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R*\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u00030\"j\b\u0012\u0004\u0012\u00020\u0003`#8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R$\u0010.\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u00108\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R$\u00103\u001a\u00020\f2\u0006\u0010)\u001a\u00020\f8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R(\u0010:\u001a\u00020\u0012*\u0002042\u0006\u00105\u001a\u00020\u00128B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\b6\u00107\"\u0004\b8\u00109\u00a8\u0006E"}, d2 = {"Lcom/tencent/qqnt/chats/view/QQChatListTwoLevelHeader;", "Lcom/qqnt/widget/smartrefreshlayout/header/ExtTwoLevelHeader;", "Lcom/tencent/qqnt/chats/view/e;", "Lcom/tencent/qqnt/chats/view/QQChatListTwoLevelHeader$b;", "callback", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lq3/d;", "header", "u", "Lq3/f;", "refreshLayout", "Lcom/qqnt/widget/smartrefreshlayout/layout/constant/RefreshState;", "oldState", "newState", "d", "", "isDragging", "", "percent", "", "offset", HippyHeaderScrollViewController.HEADER_HEIGHT, "maxDragHeight", "B9", "Lkotlin/Function0;", "block", "E", "Landroid/widget/RelativeLayout;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/RelativeLayout;", "B", "()Landroid/widget/RelativeLayout;", ParseCommon.CONTAINER, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Req, "Ljava/util/ArrayList;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Ljava/util/ArrayList;", "callbackList", "<set-?>", ExifInterface.LATITUDE_SOUTH, "Z", "D", "()Z", "isShowing", "T", "Lcom/qqnt/widget/smartrefreshlayout/layout/constant/RefreshState;", BdhLogUtil.LogTag.Tag_Conn, "()Lcom/qqnt/widget/smartrefreshlayout/layout/constant/RefreshState;", "curStatus", "Landroid/view/View;", "value", "getScale", "(Landroid/view/View;)F", "G", "(Landroid/view/View;F)V", "scale", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attributeSet", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "U", "a", "b", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public class QQChatListTwoLevelHeader extends ExtTwoLevelHeader implements e {
    static IPatchRedirector $redirector_;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final RelativeLayout container;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<b> callbackList;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean isShowing;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private RefreshState curStatus;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/view/QQChatListTwoLevelHeader$a;", "", "", "ALL_CAN_VIEW_RATE", UserInfo.SEX_FEMALE, "<init>", "()V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.view.QQChatListTwoLevelHeader$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55228);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QQChatListTwoLevelHeader(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(Function0 block) {
        Intrinsics.checkNotNullParameter(block, "$block");
        block.invoke();
    }

    private final void G(View view, float f16) {
        if (f16 >= 1.0f) {
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
        } else {
            view.setScaleX(f16);
            view.setScaleY(f16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final ArrayList<b> A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.callbackList;
    }

    @NotNull
    public final RelativeLayout B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (RelativeLayout) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.container;
    }

    public void B9(@Nullable q3.d header, boolean isDragging, float percent, int offset, int headerHeight, int maxDragHeight) {
        List list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, header, Boolean.valueOf(isDragging), Float.valueOf(percent), Integer.valueOf(offset), Integer.valueOf(headerHeight), Integer.valueOf(maxDragHeight));
            return;
        }
        float height = getHeight();
        float f16 = offset;
        float f17 = f16 / height;
        QLog.d("ChatListTwoLevelHeader", 4, "move: " + offset + ", percent: " + percent + ", cur");
        if (f17 > 0.15f) {
            this.container.setVisibility(0);
            getView().setVisibility(0);
        } else {
            this.container.setVisibility(8);
        }
        float f18 = height * 0.15f;
        this.container.setAlpha((f16 - f18) / f18);
        RelativeLayout relativeLayout = this.container;
        G(relativeLayout, (relativeLayout.getAlpha() * 0.15f) + 0.8f);
        this.container.setPivotY(0.0f);
        this.container.setPivotX(r6.getWidth() / 2.0f);
        list = CollectionsKt___CollectionsKt.toList(this.callbackList);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((b) it.next()).b(f17);
        }
    }

    @NotNull
    public final RefreshState C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (RefreshState) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.curStatus;
    }

    public final boolean D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.isShowing;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void E(@NotNull final Function0<Unit> block) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) block);
            return;
        }
        Intrinsics.checkNotNullParameter(block, "block");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            block.invoke();
        } else {
            post(new Runnable() { // from class: com.tencent.qqnt.chats.view.f
                @Override // java.lang.Runnable
                public final void run() {
                    QQChatListTwoLevelHeader.F(Function0.this);
                }
            });
        }
    }

    @Override // r3.e
    public void E6(@NotNull q3.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) fVar);
        } else {
            e.a.h(this, fVar);
        }
    }

    @Override // r3.f
    public void Pe(@Nullable q3.d dVar, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, dVar, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            e.a.f(this, dVar, i3, i16);
        }
    }

    @Override // r3.f
    public void Tf(@Nullable q3.d dVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, dVar, Boolean.valueOf(z16));
        } else {
            e.a.e(this, dVar, z16);
        }
    }

    @Override // r3.f
    public void Z7(@Nullable q3.c cVar, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, cVar, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            e.a.c(this, cVar, i3, i16);
        }
    }

    @Override // r3.f
    public void cd(@Nullable q3.c cVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, cVar, Boolean.valueOf(z16));
        } else {
            e.a.a(this, cVar, z16);
        }
    }

    @Override // com.qqnt.widget.smartrefreshlayout.header.ExtTwoLevelHeader, com.qqnt.widget.smartrefreshlayout.header.TwoLevelHeader, com.qqnt.widget.smartrefreshlayout.layout.simple.SimpleComponent, r3.i
    public void d(@NotNull q3.f refreshLayout, @NotNull final RefreshState oldState, @NotNull final RefreshState newState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, refreshLayout, oldState, newState);
            return;
        }
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Intrinsics.checkNotNullParameter(oldState, "oldState");
        Intrinsics.checkNotNullParameter(newState, "newState");
        super.d(refreshLayout, oldState, newState);
        QLog.d("ChatListTwoLevelHeader", 1, "onStateChange: " + newState);
        if (this.curStatus == newState) {
            return;
        }
        E(new Function0<Unit>(this, oldState) { // from class: com.tencent.qqnt.chats.view.QQChatListTwoLevelHeader$onStateChanged$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ RefreshState $oldState;
            final /* synthetic */ QQChatListTwoLevelHeader this$0;

            /* compiled from: P */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes24.dex */
            public /* synthetic */ class a {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f355589a;

                static {
                    IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55221);
                    $redirector_ = redirector;
                    if (redirector != null && redirector.hasPatch((short) 1)) {
                        redirector.redirect((short) 1);
                        return;
                    }
                    int[] iArr = new int[RefreshState.values().length];
                    try {
                        iArr[RefreshState.None.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[RefreshState.PullDownToRefresh.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[RefreshState.ReleaseToRefresh.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[RefreshState.TwoLevel.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[RefreshState.ReleaseToTwoLevel.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    try {
                        iArr[RefreshState.TwoLevelReleased.ordinal()] = 6;
                    } catch (NoSuchFieldError unused6) {
                    }
                    f355589a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
                this.$oldState = oldState;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, RefreshState.this, this, oldState);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                List list;
                q3.a aVar;
                q3.a aVar2;
                q3.a aVar3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                switch (a.f355589a[RefreshState.this.ordinal()]) {
                    case 1:
                        this.this$0.B().setVisibility(8);
                        aVar = ((TwoLevelHeader) this.this$0).L;
                        aVar.getView().setVisibility(8);
                        this.this$0.isShowing = false;
                        break;
                    case 2:
                        aVar2 = ((TwoLevelHeader) this.this$0).L;
                        aVar2.getView().setVisibility(0);
                        break;
                    case 3:
                        aVar3 = ((TwoLevelHeader) this.this$0).L;
                        aVar3.getView().setVisibility(0);
                        break;
                    case 4:
                    case 5:
                    case 6:
                        this.this$0.B().setVisibility(0);
                        this.this$0.isShowing = true;
                        break;
                }
                list = CollectionsKt___CollectionsKt.toList(this.this$0.A());
                RefreshState refreshState = this.$oldState;
                RefreshState refreshState2 = RefreshState.this;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((QQChatListTwoLevelHeader.b) it.next()).a(refreshState, refreshState2);
                }
            }
        });
        this.curStatus = newState;
    }

    @Override // r3.h
    public void e(@NotNull q3.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) fVar);
        } else {
            e.a.i(this, fVar);
        }
    }

    @Override // r3.f
    public void k6(@Nullable q3.c cVar, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, cVar, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            e.a.d(this, cVar, i3, i16);
        }
    }

    @Override // r3.f
    public void kb(@Nullable q3.c cVar, boolean z16, float f16, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, cVar, Boolean.valueOf(z16), Float.valueOf(f16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        } else {
            e.a.b(this, cVar, z16, f16, i3, i16, i17);
        }
    }

    @Override // com.qqnt.widget.smartrefreshlayout.header.ExtTwoLevelHeader
    @NotNull
    public ExtTwoLevelHeader u(@Nullable q3.d header) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ExtTwoLevelHeader) iPatchRedirector.redirect((short) 9, (Object) this, (Object) header);
        }
        ExtTwoLevelHeader res = super.u(header);
        if (header != null) {
            view = header.getView();
        } else {
            view = null;
        }
        if (view != null) {
            view.setVisibility(8);
        }
        Intrinsics.checkNotNullExpressionValue(res, "res");
        return res;
    }

    @Override // r3.f
    public void vf(@Nullable q3.d dVar, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, dVar, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            e.a.g(this, dVar, i3, i16);
        }
    }

    public final void z(@NotNull b callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.callbackList.add(callback);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQChatListTwoLevelHeader(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.callbackList = new ArrayList<>();
        this.curStatus = RefreshState.None;
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.container = relativeLayout;
        relativeLayout.setVisibility(8);
        addView(relativeLayout, new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/chats/view/QQChatListTwoLevelHeader$b;", "", "", "cur", "", "b", "Lcom/qqnt/widget/smartrefreshlayout/layout/constant/RefreshState;", "oldState", "newState", "a", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public interface b {
        void a(@NotNull RefreshState oldState, @NotNull RefreshState newState);

        void b(float cur);

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes24.dex */
        public static final class a {
            public static void a(@NotNull b bVar, float f16) {
            }
        }
    }
}
