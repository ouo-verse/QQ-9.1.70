package com.tencent.qqnt.chats.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import com.qqnt.widget.smartrefreshlayout.header.ExtTwoLevelHeader;
import com.qqnt.widget.smartrefreshlayout.layout.constant.RefreshState;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.hippy.qq.view.scroll.HippyHeaderScrollViewController;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.view.e;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u00013B\u0011\b\u0016\u0012\u0006\u0010-\u001a\u00020,\u00a2\u0006\u0004\b.\u0010/B\u001b\b\u0016\u0012\u0006\u0010-\u001a\u00020,\u0012\b\u00101\u001a\u0004\u0018\u000100\u00a2\u0006\u0004\b.\u00102J\u0006\u0010\u0004\u001a\u00020\u0003J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J8\u0010\u0016\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012R\u0014\u0010\u0019\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R$\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR$\u0010#\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000e8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R(\u0010+\u001a\u00020\u0010*\u00020%2\u0006\u0010&\u001a\u00020\u00108B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*\u00a8\u00064"}, d2 = {"Lcom/tencent/qqnt/chats/view/ChatListTwoLevelHeader;", "Lcom/qqnt/widget/smartrefreshlayout/header/ExtTwoLevelHeader;", "Lcom/tencent/qqnt/chats/view/e;", "Landroid/widget/FrameLayout;", "w", "Lq3/f;", "refreshLayout", "Lcom/qqnt/widget/smartrefreshlayout/layout/constant/RefreshState;", "oldState", "newState", "", "d", "Lq3/d;", "header", "", "isDragging", "", "percent", "", "offset", HippyHeaderScrollViewController.HEADER_HEIGHT, "maxDragHeight", "B9", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/FrameLayout;", ParseCommon.CONTAINER, "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/chats/view/ChatListTwoLevelHeader$a;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Req, "Ljava/util/ArrayList;", "callbackList", "<set-?>", ExifInterface.LATITUDE_SOUTH, "Z", "isShowing", "()Z", "Landroid/view/View;", "value", "getScale", "(Landroid/view/View;)F", HippyTKDListViewAdapter.X, "(Landroid/view/View;F)V", "scale", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attributeSet", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public class ChatListTwoLevelHeader extends ExtTwoLevelHeader implements e {
    static IPatchRedirector $redirector_;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final FrameLayout container;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<a> callbackList;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean isShowing;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/chats/view/ChatListTwoLevelHeader$a;", "", "", "cur", "", "b", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public interface a {
        void b(float cur);
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f355566a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46523);
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
                iArr[RefreshState.TwoLevel.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RefreshState.ReleaseToTwoLevel.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RefreshState.TwoLevelReleased.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f355566a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ChatListTwoLevelHeader(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
    }

    private final void x(View view, float f16) {
        view.setScaleX(f16);
        view.setScaleY(f16);
    }

    @Override // r3.f
    public final void B9(@Nullable q3.d header, boolean isDragging, float percent, int offset, int headerHeight, int maxDragHeight) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, header, Boolean.valueOf(isDragging), Float.valueOf(percent), Integer.valueOf(offset), Integer.valueOf(headerHeight), Integer.valueOf(maxDragHeight));
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("ChatListTwoLevelHeader", 4, "move: " + offset + ", percent: " + percent + ", " + (offset / headerHeight));
        }
        if (offset > headerHeight * 0.2d) {
            this.container.setVisibility(0);
            getView().setVisibility(0);
        }
        float f16 = offset;
        float f17 = headerHeight;
        this.container.setAlpha((f16 - (f17 * 0.2f)) / (0.6f * f17));
        FrameLayout frameLayout = this.container;
        x(frameLayout, (frameLayout.getAlpha() * 0.2f) + 0.8f);
        Iterator<T> it = this.callbackList.iterator();
        while (it.hasNext()) {
            ((a) it.next()).b(f16 / f17);
        }
    }

    @Override // r3.e
    public void E6(@NotNull q3.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) fVar);
        } else {
            e.a.h(this, fVar);
        }
    }

    @Override // r3.f
    public void Pe(@Nullable q3.d dVar, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, dVar, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            e.a.f(this, dVar, i3, i16);
        }
    }

    @Override // r3.f
    public void Tf(@Nullable q3.d dVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, dVar, Boolean.valueOf(z16));
        } else {
            e.a.e(this, dVar, z16);
        }
    }

    @Override // r3.f
    public void Z7(@Nullable q3.c cVar, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, cVar, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            e.a.c(this, cVar, i3, i16);
        }
    }

    @Override // r3.f
    public void cd(@Nullable q3.c cVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, cVar, Boolean.valueOf(z16));
        } else {
            e.a.a(this, cVar, z16);
        }
    }

    @Override // com.qqnt.widget.smartrefreshlayout.header.ExtTwoLevelHeader, com.qqnt.widget.smartrefreshlayout.header.TwoLevelHeader, com.qqnt.widget.smartrefreshlayout.layout.simple.SimpleComponent, r3.i
    public void d(@NotNull q3.f refreshLayout, @NotNull RefreshState oldState, @NotNull RefreshState newState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, refreshLayout, oldState, newState);
            return;
        }
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Intrinsics.checkNotNullParameter(oldState, "oldState");
        Intrinsics.checkNotNullParameter(newState, "newState");
        super.d(refreshLayout, oldState, newState);
        if (QLog.isDevelopLevel()) {
            QLog.d("ChatListTwoLevelHeader", 4, "onStateChange: " + newState);
        }
        int i3 = b.f355566a[newState.ordinal()];
        if (i3 != 1) {
            if (i3 == 2 || i3 == 3 || i3 == 4) {
                getView().setVisibility(0);
                this.container.setVisibility(0);
                this.isShowing = true;
                return;
            }
            return;
        }
        this.container.setVisibility(8);
        getView().setVisibility(8);
        this.isShowing = false;
    }

    @Override // r3.h
    public void e(@NotNull q3.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) fVar);
        } else {
            e.a.i(this, fVar);
        }
    }

    @Override // r3.f
    public void k6(@Nullable q3.c cVar, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, cVar, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            e.a.d(this, cVar, i3, i16);
        }
    }

    @Override // r3.f
    public void kb(@Nullable q3.c cVar, boolean z16, float f16, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, cVar, Boolean.valueOf(z16), Float.valueOf(f16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        } else {
            e.a.b(this, cVar, z16, f16, i3, i16, i17);
        }
    }

    @Override // r3.f
    public void vf(@Nullable q3.d dVar, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, dVar, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            e.a.g(this, dVar, i3, i16);
        }
    }

    @NotNull
    public final FrameLayout w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.container;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatListTwoLevelHeader(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.callbackList = new ArrayList<>();
        FrameLayout frameLayout = new FrameLayout(context);
        this.container = frameLayout;
        frameLayout.setVisibility(8);
        getView().setVisibility(8);
        addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
    }
}
