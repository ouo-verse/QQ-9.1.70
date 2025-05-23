package bp1;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 12\u00020\u0001:\u0001\nB'\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b/\u00100J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u0016\u0010\u0019\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0013R\u0016\u0010\u001b\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0013R\u0016\u0010\u001d\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0013R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0013R$\u0010(\u001a\u00020\t2\u0006\u0010$\u001a\u00020\t8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b\u0012\u0010'R\"\u0010,\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010&\u001a\u0004\b*\u0010'\"\u0004\b\u0015\u0010+\u00a8\u00062"}, d2 = {"Lbp1/aa;", "", "Landroid/content/Context;", "context", "", "e", "Landroid/view/MotionEvent;", "ev", "b", "", "a", "Lbp1/q;", "Lbp1/q;", "getter", "Lbp1/p;", "Lbp1/p;", "dyUpdater", "", "c", UserInfo.SEX_FEMALE, "downY", "d", "pageStartY", "xDistance", "f", "yDistance", "g", "xLast", tl.h.F, "yLast", "", "i", "I", "scaledTouchSlop", "j", "prevY", "<set-?>", "k", "Z", "()Z", "isTouch", "l", "getCanIntercept", "(Z)V", "canIntercept", "Lbp1/r;", "updater", "<init>", "(Lbp1/q;Lbp1/r;Lbp1/p;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class aa {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final q getter;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final p dyUpdater;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private float downY;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float pageStartY;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float xDistance;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float yDistance;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private float xLast;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float yLast;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int scaledTouchSlop;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private float prevY;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean isTouch;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean canIntercept;

    public aa(@NotNull q getter, @Nullable r rVar, @Nullable p pVar) {
        Intrinsics.checkNotNullParameter(getter, "getter");
        this.getter = getter;
        this.dyUpdater = pVar;
        this.canIntercept = true;
    }

    public final boolean a(@NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        int action = ev5.getAction();
        if (action != 0) {
            if (action != 2) {
                this.isTouch = false;
            } else {
                float x16 = ev5.getX();
                float y16 = ev5.getY();
                this.xDistance += Math.abs(x16 - this.xLast);
                float abs = this.yDistance + Math.abs(y16 - this.yLast);
                this.yDistance = abs;
                this.xLast = x16;
                this.yLast = y16;
                if (this.xDistance >= abs || abs < this.scaledTouchSlop || !this.canIntercept) {
                    return false;
                }
                return true;
            }
        } else {
            this.yDistance = 0.0f;
            this.xDistance = 0.0f;
            this.xLast = ev5.getX();
            this.yLast = ev5.getY();
            this.downY = ev5.getRawY();
            this.pageStartY = this.getter.getOffset();
        }
        return false;
    }

    public final void b(@NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        if (ev5.getToolType(ev5.getActionIndex()) == 0) {
            return;
        }
        if (ev5.getActionMasked() == 0) {
            float rawY = ev5.getRawY();
            this.downY = rawY;
            this.prevY = rawY;
            this.pageStartY = this.getter.getOffset();
            this.isTouch = true;
            return;
        }
        if (ev5.getActionMasked() == 2) {
            if (!this.isTouch) {
                float rawY2 = ev5.getRawY();
                this.downY = rawY2;
                this.prevY = rawY2;
                this.pageStartY = this.getter.getOffset();
                this.isTouch = true;
            }
            ev5.getRawY();
            float rawY3 = ev5.getRawY() - this.prevY;
            p pVar = this.dyUpdater;
            if (pVar != null) {
                pVar.update(-((int) rawY3), true);
            }
            this.prevY = ev5.getRawY();
            return;
        }
        if (ev5.getActionMasked() == 1) {
            float rawY4 = ev5.getRawY() - this.prevY;
            p pVar2 = this.dyUpdater;
            if (pVar2 != null) {
                pVar2.update(-((int) rawY4), false);
            }
            this.prevY = ev5.getRawY();
            this.isTouch = false;
            return;
        }
        p pVar3 = this.dyUpdater;
        if (pVar3 != null) {
            pVar3.update(0, false);
        }
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsTouch() {
        return this.isTouch;
    }

    public final void d(boolean z16) {
        this.canIntercept = z16;
    }

    public final void e(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public /* synthetic */ aa(q qVar, r rVar, p pVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(qVar, (i3 & 2) != 0 ? null : rVar, (i3 & 4) != 0 ? null : pVar);
    }
}
