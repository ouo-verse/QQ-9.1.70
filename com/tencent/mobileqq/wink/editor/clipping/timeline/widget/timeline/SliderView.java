package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timeline;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.videocut.utils.s;
import java.util.LinkedHashMap;
import java.util.Map;
import k63.a;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001*B)\b\u0007\u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010&\u001a\u00020\u001a\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\fH\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0017J\u0010\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0018\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/timeline/SliderView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", "init", "Landroid/view/MotionEvent;", "e", "", "p", "event", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "l", "", "rawX", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "moveX", "t", "r", "onTouchEvent", "Lk63/a;", "sliderListener", "setSliderListener", "Lk63/a;", BdhLogUtil.LogTag.Tag_Conn, "Z", "isDragging", "", "D", "I", "touchSlop", "E", UserInfo.SEX_FEMALE, "lastRawX", "isHandle", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "H", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class SliderView extends AppCompatImageView {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isDragging;

    /* renamed from: D, reason: from kotlin metadata */
    private final int touchSlop;

    /* renamed from: E, reason: from kotlin metadata */
    private float lastRawX;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isHandle;

    @NotNull
    public Map<Integer, View> G;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a sliderListener;

    @JvmOverloads
    public SliderView(@Nullable Context context) {
        this(context, null, 0, 6, null);
    }

    private final void init() {
        setScaleType(ImageView.ScaleType.CENTER);
    }

    private final void l() {
        this.isDragging = false;
        this.lastRawX = 0.0f;
        getParent().requestDisallowInterceptTouchEvent(false);
        r();
        this.isHandle = true;
    }

    private final void m(MotionEvent event) {
        if (p(event)) {
            getParent().requestDisallowInterceptTouchEvent(true);
            q(event.getRawX());
            s.f384267a.a(this);
            this.lastRawX = event.getRawX();
            this.isHandle = true;
        }
    }

    private final void o(MotionEvent event) {
        float rawX = event.getRawX();
        getParent().requestDisallowInterceptTouchEvent(true);
        this.isDragging = true;
        t(event, rawX);
    }

    private final boolean p(MotionEvent e16) {
        if (e16.getX() >= 0.0f && e16.getX() <= getWidth()) {
            return true;
        }
        return false;
    }

    private final void q(float rawX) {
        a aVar = this.sliderListener;
        if (aVar != null) {
            aVar.b(rawX);
        }
    }

    private final void r() {
        a aVar = this.sliderListener;
        if (aVar != null) {
            aVar.a();
        }
    }

    private final void t(MotionEvent event, float moveX) {
        a aVar = this.sliderListener;
        if (aVar != null) {
            aVar.c(event, moveX);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0013, code lost:
    
        if (r0 != 3) goto L17;
     */
    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(@Nullable MotionEvent event) {
        if (event == null) {
            return false;
        }
        this.isHandle = false;
        int action = event.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    o(event);
                }
            }
            l();
        } else {
            m(event);
        }
        return this.isHandle;
    }

    public final void setSliderListener(@Nullable a sliderListener) {
        this.sliderListener = sliderListener;
    }

    @JvmOverloads
    public SliderView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SliderView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.G = new LinkedHashMap();
        Intrinsics.checkNotNull(context);
        this.touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        init();
    }

    public /* synthetic */ SliderView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }
}
