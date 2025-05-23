package com.tencent.qqnt.base.widget;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \"2\u00020\u0001:\u0001#B)\b\u0007\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0004\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016R\"\u0010\f\u001a\u00020\u000b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0013\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0013R\u0014\u0010\u001a\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0013\u00a8\u0006$"}, d2 = {"Lcom/tencent/qqnt/base/widget/RoundRectImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", "checkPathChanged", "", "radius", "roundMode", "setCornerRadiusAndMode", "Landroid/graphics/Canvas;", PM.CANVAS, "draw", "Landroid/graphics/Path;", "mRoundPath", "Landroid/graphics/Path;", "getMRoundPath", "()Landroid/graphics/Path;", "setMRoundPath", "(Landroid/graphics/Path;)V", "mRadius", "I", "mRoundMode", "getMRoundMode", "()I", "setMRoundMode", "(I)V", "mLastRadius", "mLastRoundMode", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "a", "ntui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public class RoundRectImageView extends AppCompatImageView {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final int MODE_ALL = 1;
    public static final int MODE_BOTTOM = 5;
    public static final int MODE_LEFT = 2;
    public static final int MODE_NONE = 0;
    public static final int MODE_RIGHT = 4;
    public static final int MODE_TOP = 3;
    private int mLastRadius;
    private final int mLastRoundMode;
    private int mRadius;
    private int mRoundMode;

    @NotNull
    private Path mRoundPath;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/base/widget/RoundRectImageView$a;", "", "", "MODE_ALL", "I", "MODE_BOTTOM", "MODE_LEFT", "MODE_NONE", "MODE_RIGHT", "MODE_TOP", "<init>", "()V", "ntui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.base.widget.RoundRectImageView$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41088);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    @JvmOverloads
    public RoundRectImageView(@Nullable Context context) {
        this(context, null, 0, 6, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            return;
        }
        iPatchRedirector.redirect((short) 10, (Object) this, (Object) context);
    }

    private final void checkPathChanged() {
        if (this.mLastRadius == this.mRadius && this.mLastRoundMode == this.mRoundMode) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        this.mLastRadius = this.mRadius;
        this.mRoundPath.reset();
        int i3 = this.mRoundMode;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            Path path = this.mRoundPath;
                            RectF rectF = new RectF(0.0f, 0.0f, width, height);
                            int i16 = this.mRadius;
                            path.addRoundRect(rectF, new float[]{0.0f, 0.0f, 0.0f, 0.0f, i16, i16, i16, i16}, Path.Direction.CW);
                            return;
                        }
                        return;
                    }
                    Path path2 = this.mRoundPath;
                    RectF rectF2 = new RectF(0.0f, 0.0f, width, height);
                    int i17 = this.mRadius;
                    path2.addRoundRect(rectF2, new float[]{0.0f, 0.0f, i17, i17, i17, i17, 0.0f, 0.0f}, Path.Direction.CW);
                    return;
                }
                Path path3 = this.mRoundPath;
                RectF rectF3 = new RectF(0.0f, 0.0f, width, height);
                int i18 = this.mRadius;
                path3.addRoundRect(rectF3, new float[]{i18, i18, i18, i18, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
                return;
            }
            Path path4 = this.mRoundPath;
            RectF rectF4 = new RectF(0.0f, 0.0f, width, height);
            int i19 = this.mRadius;
            path4.addRoundRect(rectF4, new float[]{i19, i19, 0.0f, 0.0f, 0.0f, 0.0f, i19, i19}, Path.Direction.CW);
            return;
        }
        Path path5 = this.mRoundPath;
        RectF rectF5 = new RectF(0.0f, 0.0f, width, height);
        int i26 = this.mRadius;
        path5.addRoundRect(rectF5, i26, i26, Path.Direction.CW);
    }

    @Override // android.view.View
    public void draw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.mRoundMode != 0) {
            int save = canvas.save();
            checkPathChanged();
            canvas.clipPath(this.mRoundPath);
            super.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        super.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getMRoundMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.mRoundMode;
    }

    @NotNull
    protected final Path getMRoundPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Path) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mRoundPath;
    }

    public final void setCornerRadiusAndMode(int radius, int roundMode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(radius), Integer.valueOf(roundMode));
        } else {
            this.mRadius = radius;
            this.mRoundMode = roundMode;
        }
    }

    protected final void setMRoundMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.mRoundMode = i3;
        }
    }

    protected final void setMRoundPath(@NotNull Path path) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) path);
        } else {
            Intrinsics.checkNotNullParameter(path, "<set-?>");
            this.mRoundPath = path;
        }
    }

    @JvmOverloads
    public RoundRectImageView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ RoundRectImageView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? R.attr.listViewStyle : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RoundRectImageView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNull(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        Path path = new Path();
        this.mRoundPath = path;
        path.setFillType(Path.FillType.EVEN_ODD);
    }
}
