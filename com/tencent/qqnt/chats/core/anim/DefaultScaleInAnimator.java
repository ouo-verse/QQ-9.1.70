package com.tencent.qqnt.chats.core.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Looper;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqnt.chats.core.adapter.itemdata.payload.k;
import com.tencent.raft.codegenmeta.utils.RLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u000225B\u0007\u00a2\u0006\u0004\bM\u0010NJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0016\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0002J0\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u001b\u001a\u00020\u00112\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0002J\u001e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001dH\u0002J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010!\u001a\u00020\u0004H\u0016J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0016J0\u0010#\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J<\u0010&\u001a\u00020\u00112\b\u0010$\u001a\u0004\u0018\u00010\u00022\b\u0010%\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010'\u001a\u00020\u0004H\u0016J\b\u0010(\u001a\u00020\u0011H\u0016J\u0010\u0010)\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J.\u0010/\u001a\u00020.2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016R$\u00104\u001a\u0012\u0012\u0004\u0012\u00020\u000200j\b\u0012\u0004\u0012\u00020\u0002`18\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R$\u00106\u001a\u0012\u0012\u0004\u0012\u00020\u000200j\b\u0012\u0004\u0012\u00020\u0002`18\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00103R$\u00108\u001a\u0012\u0012\u0004\u0012\u00020\u000200j\b\u0012\u0004\u0012\u00020\u0002`18\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00103R$\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u001300j\b\u0012\u0004\u0012\u00020\u0013`18\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u00103R$\u0010;\u001a\u0012\u0012\u0004\u0012\u00020\u000200j\b\u0012\u0004\u0012\u00020\u0002`18\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u00103R$\u0010=\u001a\u0012\u0012\u0004\u0012\u00020\u000200j\b\u0012\u0004\u0012\u00020\u0002`18\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u00103R\u001c\u0010B\u001a\n ?*\u0004\u0018\u00010>0>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR0\u0010F\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0Cj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f`D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010ER$\u0010J\u001a\u0012\u0012\u0004\u0012\u00020\f0Gj\b\u0012\u0004\u0012\u00020\f`H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010IR\u0016\u0010L\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010K\u00a8\u0006O"}, d2 = {"Lcom/tencent/qqnt/chats/core/anim/DefaultScaleInAnimator;", "Landroidx/recyclerview/widget/DefaultItemAnimator;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "", h.F, "i", "", "viewHolders", "cancelAll", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "o", "", "fromY", "toY", "fromX", "toX", "", "l", "Lcom/tencent/qqnt/chats/core/anim/DefaultScaleInAnimator$b;", "moveInfo", "r", "j", DomainData.DOMAIN_NAME, "", "", "payloads", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Function0;", "block", "p", "animateAdd", "endAnimations", "endAnimation", "animateMove", "oldHolder", "newHolder", "animateChange", "runPendingAnimations", "isRunning", "animateRemove", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "viewHolder", "changeFlags", "Landroidx/recyclerview/widget/RecyclerView$ItemAnimator$ItemHolderInfo;", "recordPreLayoutInformation", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "movingHV", "b", "addingVH", "c", "removingVH", "d", "e", "removeInfo", "f", "addInfo", "Landroid/view/animation/Interpolator;", "kotlin.jvm.PlatformType", "g", "Landroid/view/animation/Interpolator;", "addAnim", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "vhOldPostMap", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "forceAnimItem", "I", "curTimeMoveDirection", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class DefaultScaleInAnimator extends androidx.recyclerview.widget.DefaultItemAnimator {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<RecyclerView.ViewHolder> movingHV;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<RecyclerView.ViewHolder> addingVH;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<RecyclerView.ViewHolder> removingVH;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<b> moveInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<RecyclerView.ViewHolder> removeInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<RecyclerView.ViewHolder> addInfo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Interpolator addAnim;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, Integer> vhOldPostMap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashSet<Integer> forceAnimItem;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int curTimeMoveDirection;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/chats/core/anim/DefaultScaleInAnimator$a;", "", "", "ANIM_Z_ORDER", UserInfo.SEX_FEMALE, "", "DOWN", "I", RLog.ERROR, "NONE", "UP", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.core.anim.DefaultScaleInAnimator$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b#\u0010$J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\"\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013R\"\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\"\u0010\"\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u001e\u001a\u0004\b\n\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/qqnt/chats/core/anim/DefaultScaleInAnimator$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "f", "()Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "b", "I", "()I", h.F, "(I)V", "fromY", "c", "e", "k", "toY", "d", "j", "oldPos", "i", "newPos", "Z", "()Z", "g", "(Z)V", "forceAnim", "<init>", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final /* data */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final RecyclerView.ViewHolder viewHolder;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int fromY;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int toY;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int oldPos;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int newPos;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private boolean forceAnim;

        public b(@NotNull RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) viewHolder);
                return;
            }
            this.viewHolder = viewHolder;
            this.oldPos = -1;
            this.newPos = -1;
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
            }
            return this.forceAnim;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.fromY;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
            }
            return this.newPos;
        }

        public final int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            return this.oldPos;
        }

        public final int e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.toY;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof b) && Intrinsics.areEqual(this.viewHolder, ((b) other).viewHolder)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final RecyclerView.ViewHolder f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.viewHolder;
        }

        public final void g(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this, z16);
            } else {
                this.forceAnim = z16;
            }
        }

        public final void h(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
            } else {
                this.fromY = i3;
            }
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
            }
            return this.viewHolder.hashCode();
        }

        public final void i(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, i3);
            } else {
                this.newPos = i3;
            }
        }

        public final void j(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, i3);
            } else {
                this.oldPos = i3;
            }
        }

        public final void k(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, i3);
            } else {
                this.toY = i3;
            }
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (String) iPatchRedirector.redirect((short) 15, (Object) this);
            }
            return "PosMoveInfo(viewHolder=" + this.viewHolder + ")";
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46101);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public DefaultScaleInAnimator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.movingHV = new ArrayList<>();
        this.addingVH = new ArrayList<>();
        this.removingVH = new ArrayList<>();
        this.moveInfo = new ArrayList<>();
        this.removeInfo = new ArrayList<>();
        this.addInfo = new ArrayList<>();
        this.addAnim = AnimationUtils.loadInterpolator(MobileQQ.sMobileQQ, R.anim.f154976uj);
        this.vhOldPostMap = new HashMap<>();
        this.forceAnimItem = new HashSet<>();
        setMoveDuration(100L);
        setRemoveDuration(100L);
        setAddDuration(100L);
        setChangeDuration(100L);
        setSupportsChangeAnimations(false);
    }

    private final void cancelAll(List<? extends RecyclerView.ViewHolder> viewHolders) {
        int size = viewHolders.size() - 1;
        if (size < 0) {
            return;
        }
        while (true) {
            int i3 = size - 1;
            viewHolders.get(size).itemView.animate().cancel();
            if (i3 >= 0) {
                size = i3;
            } else {
                return;
            }
        }
    }

    private final void h(final RecyclerView.ViewHolder holder) {
        final View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        this.addingVH.add(holder);
        view.setZ(-1000.0f);
        final ViewPropertyAnimator animate = view.animate();
        animate.alpha(1.0f).translationY(0.0f).setDuration(getAddDuration()).setInterpolator(this.addAnim).setListener(new AnimatorListenerAdapter(holder, view, animate) { // from class: com.tencent.qqnt.chats.core.anim.DefaultScaleInAnimator$addAnimateImpl$1
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ RecyclerView.ViewHolder f354715e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ View f354716f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ ViewPropertyAnimator f354717h;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f354715e = holder;
                this.f354716f = view;
                this.f354717h = animate;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, DefaultScaleInAnimator.this, holder, view, animate);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animator) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                    return;
                }
                Intrinsics.checkNotNullParameter(animator, "animator");
                this.f354716f.setAlpha(1.0f);
                this.f354716f.setTranslationY(0.0f);
                this.f354716f.setZ(0.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animator) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
                    return;
                }
                Intrinsics.checkNotNullParameter(animator, "animator");
                this.f354717h.setListener(null);
                this.f354716f.setAlpha(1.0f);
                this.f354716f.setTranslationY(0.0f);
                this.f354716f.setZ(0.0f);
                DefaultScaleInAnimator.this.dispatchAddFinished(this.f354715e);
                final DefaultScaleInAnimator defaultScaleInAnimator = DefaultScaleInAnimator.this;
                final RecyclerView.ViewHolder viewHolder = this.f354715e;
                defaultScaleInAnimator.p(viewHolder, new Function0<Unit>(viewHolder) { // from class: com.tencent.qqnt.chats.core.anim.DefaultScaleInAnimator$addAnimateImpl$1$onAnimationEnd$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ RecyclerView.ViewHolder $holder;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$holder = viewHolder;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DefaultScaleInAnimator.this, (Object) viewHolder);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ArrayList arrayList;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        arrayList = DefaultScaleInAnimator.this.addingVH;
                        arrayList.remove(this.$holder);
                        DefaultScaleInAnimator.this.m();
                    }
                });
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animator) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                } else {
                    Intrinsics.checkNotNullParameter(animator, "animator");
                    DefaultScaleInAnimator.this.dispatchAddStarting(this.f354715e);
                }
            }
        }).start();
    }

    private final void i() {
        Iterator<b> it = this.moveInfo.iterator();
        while (it.hasNext()) {
            b next = it.next();
            View view = next.f().itemView;
            Intrinsics.checkNotNullExpressionValue(view, "item.viewHolder.itemView");
            view.animate().cancel();
            view.setTranslationY(0.0f);
            view.setAlpha(1.0f);
            dispatchMoveFinished(next.f());
        }
        this.moveInfo.clear();
        Iterator<RecyclerView.ViewHolder> it5 = this.addInfo.iterator();
        while (it5.hasNext()) {
            RecyclerView.ViewHolder next2 = it5.next();
            View view2 = next2.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "item.itemView");
            view2.animate().cancel();
            view2.setTranslationY(0.0f);
            view2.setAlpha(1.0f);
            dispatchAddFinished(next2);
        }
        this.addInfo.clear();
        Iterator<RecyclerView.ViewHolder> it6 = this.removeInfo.iterator();
        while (it6.hasNext()) {
            RecyclerView.ViewHolder next3 = it6.next();
            View view3 = next3.itemView;
            Intrinsics.checkNotNullExpressionValue(view3, "item.itemView");
            view3.animate().cancel();
            view3.setTranslationY(0.0f);
            view3.setAlpha(1.0f);
            dispatchRemoveFinished(next3);
        }
        this.removeInfo.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(b moveInfo) {
        final RecyclerView.ViewHolder f16 = moveInfo.f();
        final View view = f16.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        final ViewPropertyAnimator animate = view.animate();
        moveInfo.b();
        moveInfo.e();
        if (this.curTimeMoveDirection == 1) {
            view.setTranslationY((-view.getHeight()) / 4.0f);
        } else {
            view.setTranslationY(view.getHeight() / 4.0f);
        }
        view.setAlpha(0.0f);
        animate.alpha(1.0f).translationY(0.0f).setDuration(getAddDuration() / 2).setInterpolator(this.addAnim).setListener(new AnimatorListenerAdapter(view, animate, this, f16) { // from class: com.tencent.qqnt.chats.core.anim.DefaultScaleInAnimator$endMove$1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ View f354724d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ ViewPropertyAnimator f354725e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ DefaultScaleInAnimator f354726f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ RecyclerView.ViewHolder f354727h;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f354724d = view;
                this.f354725e = animate;
                this.f354726f = this;
                this.f354727h = f16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, view, animate, this, f16);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animator) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                    return;
                }
                Intrinsics.checkNotNullParameter(animator, "animator");
                this.f354724d.setAlpha(1.0f);
                this.f354724d.setTranslationY(0.0f);
                this.f354724d.setZ(0.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animator) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
                    return;
                }
                Intrinsics.checkNotNullParameter(animator, "animator");
                this.f354725e.setListener(null);
                this.f354724d.setAlpha(1.0f);
                this.f354724d.setTranslationY(0.0f);
                this.f354724d.setZ(0.0f);
                this.f354726f.dispatchMoveFinished(this.f354727h);
                final DefaultScaleInAnimator defaultScaleInAnimator = this.f354726f;
                final RecyclerView.ViewHolder viewHolder = this.f354727h;
                defaultScaleInAnimator.p(viewHolder, new Function0<Unit>(viewHolder) { // from class: com.tencent.qqnt.chats.core.anim.DefaultScaleInAnimator$endMove$1$onAnimationEnd$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ RecyclerView.ViewHolder $holder;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$holder = viewHolder;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DefaultScaleInAnimator.this, (Object) viewHolder);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ArrayList arrayList;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        arrayList = DefaultScaleInAnimator.this.movingHV;
                        arrayList.remove(this.$holder);
                        DefaultScaleInAnimator.this.m();
                    }
                });
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animator) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                } else {
                    Intrinsics.checkNotNullParameter(animator, "animator");
                }
            }
        }).start();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0037 A[EDGE_INSN: B:13:0x0037->B:14:0x0037 BREAK  A[LOOP:0: B:4:0x000f->B:19:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[LOOP:0: B:4:0x000f->B:19:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean k(List<Object> payloads) {
        Object obj;
        boolean z16;
        if (payloads.contains(k.f354602a)) {
            return true;
        }
        Iterator<T> it = payloads.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (TypeIntrinsics.isMutableList(obj)) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Any>");
                    if (k(TypeIntrinsics.asMutableList(obj))) {
                        z16 = true;
                        if (!z16) {
                            break;
                        }
                    }
                }
                z16 = false;
                if (!z16) {
                }
            } else {
                obj = null;
                break;
            }
        }
        if (obj != null) {
            return true;
        }
        return false;
    }

    private final boolean l(RecyclerView.ViewHolder holder, int fromY, int toY, int fromX, int toX) {
        int intValue;
        if (!this.addingVH.contains(holder) && !this.removingVH.contains(holder) && !this.movingHV.contains(holder)) {
            endAnimation(holder);
        }
        if (fromY == toY && fromX == toX) {
            dispatchChangeFinished(holder, false);
            return false;
        }
        ArrayList<b> arrayList = this.moveInfo;
        b bVar = new b(holder);
        bVar.h(fromY);
        bVar.k(toY);
        Integer num = this.vhOldPostMap.get(Integer.valueOf(holder.hashCode()));
        if (num == null) {
            intValue = -1;
        } else {
            Intrinsics.checkNotNullExpressionValue(num, "vhOldPostMap[holder.hashCode()] ?: -1");
            intValue = num.intValue();
        }
        bVar.j(intValue);
        bVar.i(holder.getLayoutPosition());
        bVar.g(this.forceAnimItem.remove(Integer.valueOf(holder.hashCode())));
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        view.setZ(-1000.0f);
        view.setTranslationY(fromY - toY);
        arrayList.add(bVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        if (!isRunning()) {
            dispatchAnimationsFinished();
        }
    }

    private final void n(final RecyclerView.ViewHolder holder) {
        final View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        this.removingVH.add(holder);
        if (this.curTimeMoveDirection == 2) {
            view.animate().translationY(view.getHeight() / 2.0f);
        } else {
            view.animate().translationY((-view.getHeight()) / 2.0f);
        }
        view.animate().alpha(0.0f).setDuration(getRemoveDuration()).setInterpolator(this.addAnim).setListener(new AnimatorListenerAdapter(holder, view) { // from class: com.tencent.qqnt.chats.core.anim.DefaultScaleInAnimator$removeAnimateImpl$1
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ RecyclerView.ViewHolder f354729e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ View f354730f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f354729e = holder;
                this.f354730f = view;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, DefaultScaleInAnimator.this, holder, view);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animator) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                    return;
                }
                Intrinsics.checkNotNullParameter(animator, "animator");
                this.f354730f.setAlpha(1.0f);
                this.f354730f.setTranslationY(0.0f);
                this.f354730f.setZ(0.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animation) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                    return;
                }
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.f354730f.setTranslationY(0.0f);
                this.f354730f.setAlpha(1.0f);
                this.f354730f.setZ(0.0f);
                DefaultScaleInAnimator.this.dispatchRemoveFinished(this.f354729e);
                final DefaultScaleInAnimator defaultScaleInAnimator = DefaultScaleInAnimator.this;
                final RecyclerView.ViewHolder viewHolder = this.f354729e;
                defaultScaleInAnimator.p(viewHolder, new Function0<Unit>(viewHolder) { // from class: com.tencent.qqnt.chats.core.anim.DefaultScaleInAnimator$removeAnimateImpl$1$onAnimationEnd$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ RecyclerView.ViewHolder $holder;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$holder = viewHolder;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DefaultScaleInAnimator.this, (Object) viewHolder);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ArrayList arrayList;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        arrayList = DefaultScaleInAnimator.this.removingVH;
                        arrayList.remove(this.$holder);
                        DefaultScaleInAnimator.this.m();
                    }
                });
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animator) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                } else {
                    Intrinsics.checkNotNullParameter(animator, "animator");
                    DefaultScaleInAnimator.this.dispatchRemoveStarting(this.f354729e);
                }
            }
        }).start();
    }

    private final void o(RecyclerView.ViewHolder item) {
        View view = item.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "item.itemView");
        view.setTranslationY(0.0f);
        view.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(RecyclerView.ViewHolder holder, final Function0<Unit> block) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            block.invoke();
        } else {
            holder.itemView.post(new Runnable() { // from class: com.tencent.qqnt.chats.core.anim.c
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultScaleInAnimator.q(Function0.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    private final void r(b moveInfo) {
        RecyclerView.ViewHolder f16 = moveInfo.f();
        View view = f16.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        int b16 = moveInfo.b() - moveInfo.e();
        this.movingHV.add(moveInfo.f());
        ViewPropertyAnimator animate = view.animate();
        if (this.curTimeMoveDirection == 1) {
            animate.translationY(b16 - (view.getHeight() / 4.0f));
        } else {
            animate.translationY(b16 + (view.getHeight() / 4.0f));
        }
        animate.alpha(0.0f);
        animate.setDuration(getRemoveDuration() / 2);
        animate.setInterpolator(this.addAnim);
        animate.setListener(new DefaultScaleInAnimator$startMove$1$1(this, f16, view, moveInfo));
        animate.start();
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateAdd(@NotNull RecyclerView.ViewHolder holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) holder)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        endAnimation(holder);
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        view.setAlpha(0.0f);
        view.setTranslationY((-view.getHeight()) / 2.0f);
        view.setZ(-1000.0f);
        this.addInfo.add(holder);
        this.vhOldPostMap.remove(Integer.valueOf(holder.hashCode()));
        this.forceAnimItem.remove(Integer.valueOf(holder.hashCode()));
        return true;
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateChange(@Nullable RecyclerView.ViewHolder oldHolder, @Nullable RecyclerView.ViewHolder newHolder, int fromX, int fromY, int toX, int toY) {
        int i3;
        int i16;
        int i17;
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, oldHolder, newHolder, Integer.valueOf(fromX), Integer.valueOf(fromY), Integer.valueOf(toX), Integer.valueOf(toY))).booleanValue();
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("animateChange: ");
        sb5.append(newHolder);
        sb5.append(" oldHolder: ");
        sb5.append(oldHolder);
        StringBuilder sb6 = new StringBuilder();
        sb6.append("from: ");
        sb6.append(fromY);
        sb6.append(" to: ");
        sb6.append(toY);
        if (Intrinsics.areEqual(oldHolder, newHolder) && oldHolder != null) {
            boolean l3 = l(oldHolder, fromY, toY, fromX, toX);
            this.vhOldPostMap.remove(Integer.valueOf(oldHolder.hashCode()));
            this.forceAnimItem.remove(Integer.valueOf(oldHolder.hashCode()));
            return l3;
        }
        if (oldHolder != null) {
            endAnimation(oldHolder);
        }
        if (newHolder != null) {
            endAnimation(newHolder);
        }
        dispatchChangeFinished(oldHolder, true);
        dispatchChangeFinished(newHolder, false);
        HashMap<Integer, Integer> hashMap = this.vhOldPostMap;
        if (oldHolder != null) {
            i3 = oldHolder.hashCode();
        } else {
            i3 = 0;
        }
        hashMap.remove(Integer.valueOf(i3));
        HashMap<Integer, Integer> hashMap2 = this.vhOldPostMap;
        if (newHolder != null) {
            i16 = newHolder.hashCode();
        } else {
            i16 = 0;
        }
        hashMap2.remove(Integer.valueOf(i16));
        HashSet<Integer> hashSet = this.forceAnimItem;
        if (oldHolder != null) {
            i17 = oldHolder.hashCode();
        } else {
            i17 = 0;
        }
        hashSet.remove(Integer.valueOf(i17));
        HashSet<Integer> hashSet2 = this.forceAnimItem;
        if (newHolder != null) {
            i18 = newHolder.hashCode();
        } else {
            i18 = 0;
        }
        hashSet2.remove(Integer.valueOf(i18));
        return false;
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateMove(@NotNull RecyclerView.ViewHolder holder, int fromX, int fromY, int toX, int toY) {
        boolean animateMove;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, holder, Integer.valueOf(fromX), Integer.valueOf(fromY), Integer.valueOf(toX), Integer.valueOf(toY))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        Integer num = this.vhOldPostMap.get(Integer.valueOf(holder.hashCode()));
        if (num == null) {
            num = -1;
        }
        int intValue = num.intValue();
        int abs = Math.abs(fromY - toY);
        if (Math.abs(intValue - holder.getAdapterPosition()) > 1 && intValue != -1 && abs > holder.itemView.getHeight() * 1.5d) {
            animateMove = l(holder, fromY, toY, fromX, toX);
        } else {
            int i16 = this.curTimeMoveDirection;
            if (fromY > toY) {
                i3 = 1;
            }
            this.curTimeMoveDirection = i16 | i3;
            animateMove = super.animateMove(holder, fromX, fromY, toX, toY);
        }
        ViewPropertyAnimator animate = holder.itemView.animate();
        if (animate != null) {
            animate.setInterpolator(this.addAnim);
        }
        this.vhOldPostMap.remove(Integer.valueOf(holder.hashCode()));
        this.forceAnimItem.remove(Integer.valueOf(holder.hashCode()));
        return animateMove;
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateRemove(@NotNull RecyclerView.ViewHolder holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) holder)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        endAnimation(holder);
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        view.setZ(-1000.0f);
        this.removeInfo.add(holder);
        this.vhOldPostMap.remove(Integer.valueOf(holder.hashCode()));
        this.forceAnimItem.remove(Integer.valueOf(holder.hashCode()));
        return true;
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimation(@NotNull RecyclerView.ViewHolder item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        super.endAnimation(item);
        o(item);
        if (this.addInfo.contains(item)) {
            this.addInfo.remove(item);
            dispatchAddFinished(item);
        }
        if (this.removeInfo.contains(item)) {
            this.removeInfo.remove(item);
            dispatchRemoveFinished(item);
        }
        if (this.moveInfo.contains(new b(item))) {
            this.moveInfo.remove(this.moveInfo.indexOf(new b(item)));
            dispatchMoveFinished(item);
        }
        this.removingVH.remove(item);
        this.addingVH.remove(item);
        this.movingHV.remove(item);
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimations() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        i();
        cancelAll(this.addingVH);
        cancelAll(this.removingVH);
        cancelAll(this.movingHV);
        this.curTimeMoveDirection = 0;
        super.endAnimations();
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean isRunning() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (super.isRunning() || (!this.movingHV.isEmpty()) || (!this.addingVH.isEmpty()) || (!this.removingVH.isEmpty()) || (!this.moveInfo.isEmpty()) || (!this.addInfo.isEmpty()) || (!this.removeInfo.isEmpty())) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    @NotNull
    public RecyclerView.ItemAnimator.ItemHolderInfo recordPreLayoutInformation(@NotNull RecyclerView.State state, @NotNull RecyclerView.ViewHolder viewHolder, int changeFlags, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (RecyclerView.ItemAnimator.ItemHolderInfo) iPatchRedirector.redirect((short) 10, this, state, viewHolder, Integer.valueOf(changeFlags), payloads);
        }
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        this.vhOldPostMap.put(Integer.valueOf(viewHolder.hashCode()), Integer.valueOf(viewHolder.getOldPosition()));
        if (k(payloads)) {
            this.forceAnimItem.add(Integer.valueOf(viewHolder.hashCode()));
        }
        RecyclerView.ItemAnimator.ItemHolderInfo recordPreLayoutInformation = super.recordPreLayoutInformation(state, viewHolder, changeFlags, payloads);
        Intrinsics.checkNotNullExpressionValue(recordPreLayoutInformation, "super.recordPreLayoutInf\u2026r, changeFlags, payloads)");
        return recordPreLayoutInformation;
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void runPendingAnimations() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if ((!this.moveInfo.isEmpty() ? 1 : 0) + (!this.addInfo.isEmpty() ? 1 : 0) + (!this.removeInfo.isEmpty() ? 1 : 0) <= 1 && this.moveInfo.size() + this.addInfo.size() + this.removeInfo.size() <= 3 && this.moveInfo.size() <= 1) {
            if (this.moveInfo.size() == 1 && Math.abs(this.moveInfo.get(0).d() - this.moveInfo.get(0).c()) <= 15 && !this.moveInfo.get(0).a()) {
                endAnimations();
                return;
            }
            if (this.curTimeMoveDirection == 3) {
                endAnimations();
                return;
            }
            Iterator<T> it = this.moveInfo.iterator();
            while (it.hasNext()) {
                r((b) it.next());
            }
            this.moveInfo.clear();
            Iterator<T> it5 = this.addInfo.iterator();
            while (it5.hasNext()) {
                h((RecyclerView.ViewHolder) it5.next());
            }
            this.addInfo.clear();
            Iterator<T> it6 = this.removeInfo.iterator();
            while (it6.hasNext()) {
                n((RecyclerView.ViewHolder) it6.next());
            }
            this.removeInfo.clear();
            this.curTimeMoveDirection = 0;
            super.runPendingAnimations();
            return;
        }
        endAnimations();
    }
}
