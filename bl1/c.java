package bl1;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.LikeUI;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.NavigatorUI;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.k;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionType;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import wk1.InputStyleConfig;
import x12.v;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 12\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u00a2\u0006\u0004\b/\u00100J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0014\u0010\u0011\u001a\u00020\u00042\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u001a\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016R\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020!0 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00062"}, d2 = {"Lbl1/c;", "Lal1/a;", "Landroid/view/ViewGroup;", "parentView", "", "a", "root", "b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionType;", "speakPermission", "", "N4", "D5", "zc", "Lqj1/b;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IBottomInteractDisplayable;", "data", "E7", "V4", "enable", "u1", "", "key", "", "msg", "lh", "action", "I2", "Lwk1/h;", "d", "Lwk1/h;", "inputContext", "", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/layout/main/ui/d;", "e", "Ljava/util/List;", "childUIList", "f", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionType;", "curSpeakPermission", "Lx12/v;", h.F, "Lx12/v;", "commonLayoutBinding", "i", "Z", "needDispatchContextInfoChanged", "<init>", "(Lwk1/h;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c implements al1.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final wk1.h inputContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private List<? extends com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d> childUIList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private SpeakPermissionType curSpeakPermission;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private v commonLayoutBinding;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean needDispatchContextInfoChanged;

    public c(@NotNull wk1.h inputContext) {
        Intrinsics.checkNotNullParameter(inputContext, "inputContext");
        this.inputContext = inputContext;
        this.curSpeakPermission = SpeakPermissionType.PERMISSION_TYPE_INVALID;
    }

    private final void a(ViewGroup parentView) {
        Drawable backgroundColor;
        v g16 = v.g(LayoutInflater.from(parentView.getContext()), parentView, false);
        InputStyleConfig d16 = this.inputContext.d();
        if (d16 != null && (backgroundColor = d16.getBackgroundColor()) != null) {
            g16.getRoot().setBackground(backgroundColor);
        }
        ConstraintLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "this.root");
        b(root);
        this.commonLayoutBinding = g16;
    }

    private final void b(ViewGroup root) {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new cl1.b(this.inputContext), new LikeUI(this.inputContext), new com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.b(this.inputContext), new k(this.inputContext), new com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.c(this.inputContext));
        wk1.a guildBarDependency = this.inputContext.getGuildBarDependency();
        if (guildBarDependency != null) {
            arrayListOf.add(new NavigatorUI(guildBarDependency));
        }
        this.childUIList = arrayListOf;
        if (arrayListOf == null) {
            Intrinsics.throwUninitializedPropertyAccessException("childUIList");
            arrayListOf = null;
        }
        Iterator it = arrayListOf.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d) it.next()).init(root);
        }
    }

    @Override // al1.a
    public void D5(@NotNull ViewGroup parentView, @NotNull SpeakPermissionType speakPermission) {
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        Intrinsics.checkNotNullParameter(speakPermission, "speakPermission");
        QLog.i("MainInputLayout", 1, "showLayout speakPermission = " + speakPermission);
        this.curSpeakPermission = speakPermission;
        if (this.commonLayoutBinding == null) {
            a(parentView);
        }
        List<? extends com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d> list = this.childUIList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("childUIList");
            list = null;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d) it.next()).e(this.curSpeakPermission);
        }
        v vVar = this.commonLayoutBinding;
        Intrinsics.checkNotNull(vVar);
        if (vVar.getRoot().getParent() == null) {
            v vVar2 = this.commonLayoutBinding;
            Intrinsics.checkNotNull(vVar2);
            parentView.addView(vVar2.getRoot());
        }
        if (this.needDispatchContextInfoChanged) {
            V4();
        }
    }

    @Override // al1.a
    public void E7(@NotNull qj1.b data) {
        ViewParent viewParent;
        ConstraintLayout root;
        Intrinsics.checkNotNullParameter(data, "data");
        v vVar = this.commonLayoutBinding;
        List<? extends com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d> list = null;
        if (vVar != null && (root = vVar.getRoot()) != null) {
            viewParent = root.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent == null) {
            return;
        }
        List<? extends com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d> list2 = this.childUIList;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("childUIList");
        } else {
            list = list2;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d) it.next()).b(data);
        }
    }

    @Override // wk1.i
    @Nullable
    public Object I2(@NotNull String action, @Nullable Object msg2) {
        ViewParent viewParent;
        ConstraintLayout root;
        Intrinsics.checkNotNullParameter(action, "action");
        v vVar = this.commonLayoutBinding;
        if (vVar != null && (root = vVar.getRoot()) != null) {
            viewParent = root.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent == null) {
            return null;
        }
        List<? extends com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d> list = this.childUIList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("childUIList");
            list = null;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Object d16 = ((com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d) it.next()).d(action, msg2);
            if (d16 != null) {
                return d16;
            }
        }
        return null;
    }

    @Override // al1.a
    public boolean N4(@NotNull SpeakPermissionType speakPermission) {
        Intrinsics.checkNotNullParameter(speakPermission, "speakPermission");
        if (speakPermission != SpeakPermissionType.PERMISSION_TYPE_SIMPLE_INIT && speakPermission != SpeakPermissionType.PERMISSION_TYPE_NORMAL && speakPermission != SpeakPermissionType.PERMISSION_TYPE_VISITOR_NEED_JOIN && speakPermission != SpeakPermissionType.PERMISSION_TYPE_REAL_NAME && speakPermission != SpeakPermissionType.PERMISSION_TYPE_JOIN_TIME && speakPermission != SpeakPermissionType.PERMISSION_TYPE_ALL_MUTED && speakPermission != SpeakPermissionType.PERMISSION_TYPE_SELF_MUTED) {
            return false;
        }
        return true;
    }

    @Override // al1.a
    public void V4() {
        ViewParent viewParent;
        ConstraintLayout root;
        v vVar = this.commonLayoutBinding;
        List<? extends com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d> list = null;
        if (vVar != null && (root = vVar.getRoot()) != null) {
            viewParent = root.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent != null) {
            List<? extends com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d> list2 = this.childUIList;
            if (list2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("childUIList");
            } else {
                list = list2;
            }
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d) it.next()).a();
            }
            this.needDispatchContextInfoChanged = false;
            return;
        }
        this.needDispatchContextInfoChanged = true;
    }

    @Override // wk1.i
    public void lh(@NotNull String key, @Nullable Object msg2) {
        ViewParent viewParent;
        ConstraintLayout root;
        Intrinsics.checkNotNullParameter(key, "key");
        v vVar = this.commonLayoutBinding;
        List<? extends com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d> list = null;
        if (vVar != null && (root = vVar.getRoot()) != null) {
            viewParent = root.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent == null) {
            return;
        }
        List<? extends com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d> list2 = this.childUIList;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("childUIList");
        } else {
            list = list2;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d) it.next()).c(key, msg2);
        }
    }

    @Override // al1.a
    public void u1(boolean enable) {
        List<? extends com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d> list = this.childUIList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("childUIList");
            list = null;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d) it.next()).u1(enable);
        }
    }

    @Override // al1.a
    public void zc(@NotNull ViewGroup parentView, @NotNull SpeakPermissionType speakPermission) {
        ViewParent viewParent;
        ConstraintLayout root;
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        Intrinsics.checkNotNullParameter(speakPermission, "speakPermission");
        this.curSpeakPermission = speakPermission;
        v vVar = this.commonLayoutBinding;
        List<? extends com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d> list = null;
        if (vVar != null && (root = vVar.getRoot()) != null) {
            viewParent = root.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent == null) {
            return;
        }
        List<? extends com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d> list2 = this.childUIList;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("childUIList");
        } else {
            list = list2;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d) it.next()).e(this.curSpeakPermission);
        }
        v vVar2 = this.commonLayoutBinding;
        Intrinsics.checkNotNull(vVar2);
        parentView.removeView(vVar2.getRoot());
    }
}
