package com.tencent.mobileqq.guild.animate.subchannellist;

import android.animation.TimeInterpolator;
import android.os.Handler;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.tencent.mobileqq.guild.animate.subchannellist.a;
import com.tencent.mobileqq.guild.animate.subchannellist.b;
import com.tencent.mobileqq.guild.animate.subchannellist.c;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import we1.c;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildChannelListAnim extends SimpleItemAnimator {

    /* renamed from: m, reason: collision with root package name */
    private static final TimeInterpolator f214277m = new DecelerateInterpolator();

    /* renamed from: n, reason: collision with root package name */
    private static final float f214278n = ViewUtils.dpToPx(15.0f);

    /* renamed from: f, reason: collision with root package name */
    private final h f214284f;

    /* renamed from: j, reason: collision with root package name */
    private final we1.a f214288j;

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<RecyclerView.ViewHolder> f214279a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList<RecyclerView.ViewHolder> f214280b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList<i> f214281c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    private final ArrayList<e> f214282d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    private final ArrayList<g> f214283e = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    private final com.tencent.mobileqq.guild.animate.subchannellist.a f214285g = p();

    /* renamed from: h, reason: collision with root package name */
    private final com.tencent.mobileqq.guild.animate.subchannellist.b f214286h = r();

    /* renamed from: i, reason: collision with root package name */
    private final com.tencent.mobileqq.guild.animate.subchannellist.c f214287i = s();

    /* renamed from: k, reason: collision with root package name */
    private final Handler f214289k = new Handler();

    /* renamed from: l, reason: collision with root package name */
    private final Runnable f214290l = o();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements a.b {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.animate.subchannellist.a.b
        public void a() {
            GuildChannelListAnim.this.dispatchFinishedWhenDone();
        }

        @Override // com.tencent.mobileqq.guild.animate.subchannellist.a.b
        public void b(RecyclerView.ViewHolder viewHolder) {
            GuildChannelListAnim.this.dispatchAddStarting(viewHolder);
        }

        @Override // com.tencent.mobileqq.guild.animate.subchannellist.a.b
        public void c(RecyclerView.ViewHolder viewHolder) {
            GuildChannelListAnim.this.dispatchAddFinished(viewHolder);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements b.InterfaceC7673b {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.animate.subchannellist.b.InterfaceC7673b
        public void a() {
            GuildChannelListAnim.this.dispatchFinishedWhenDone();
        }

        @Override // com.tencent.mobileqq.guild.animate.subchannellist.b.InterfaceC7673b
        public void b(RecyclerView.ViewHolder viewHolder) {
            GuildChannelListAnim.this.dispatchMoveStarting(viewHolder);
        }

        @Override // com.tencent.mobileqq.guild.animate.subchannellist.b.InterfaceC7673b
        public void c(RecyclerView.ViewHolder viewHolder) {
            GuildChannelListAnim.this.dispatchMoveFinished(viewHolder);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements c.b {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.animate.subchannellist.c.b
        public void a() {
            GuildChannelListAnim.this.dispatchFinishedWhenDone();
        }

        @Override // com.tencent.mobileqq.guild.animate.subchannellist.c.b
        public void b(RecyclerView.ViewHolder viewHolder) {
            GuildChannelListAnim.this.dispatchRemoveFinished(viewHolder);
        }

        @Override // com.tencent.mobileqq.guild.animate.subchannellist.c.b
        public void c(RecyclerView.ViewHolder viewHolder) {
            GuildChannelListAnim.this.dispatchRemoveStarting(viewHolder);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d implements c.b {
        d() {
        }

        @Override // we1.c.b
        public void a() {
            GuildChannelListAnim.this.dispatchFinishedWhenDone();
        }

        @Override // we1.c.b
        public void b() {
            GuildChannelListAnim.this.f214284f.b();
        }

        @Override // we1.c.b
        public void c() {
            GuildChannelListAnim.this.f214284f.c();
        }

        @Override // we1.c.b
        public void d(RecyclerView.ViewHolder viewHolder) {
            GuildChannelListAnim.this.resetAnimation(viewHolder);
        }

        @Override // we1.c.b
        public boolean e(RecyclerView.ViewHolder viewHolder, int i3, int i16, int i17, int i18) {
            return GuildChannelListAnim.this.animateMove(viewHolder, i3, i16, i17, i18);
        }

        @Override // we1.c.b
        public void f(RecyclerView.ViewHolder viewHolder, boolean z16) {
            GuildChannelListAnim.this.dispatchChangeStarting(viewHolder, z16);
        }

        @Override // we1.c.b
        public void g(RecyclerView.ViewHolder viewHolder, boolean z16) {
            GuildChannelListAnim.this.dispatchChangeFinished(viewHolder, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class f extends RecyclerView.ItemAnimator.ItemHolderInfo {

        /* renamed from: a, reason: collision with root package name */
        public boolean f214301a = false;

        /* renamed from: b, reason: collision with root package name */
        public boolean f214302b = false;

        public String toString() {
            return "ChannelItemHolderInfo{isExpand=" + this.f214301a + ", isCollapse=" + this.f214302b + '}';
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.ViewHolder f214303a;

        /* renamed from: b, reason: collision with root package name */
        public RecyclerView.ViewHolder f214304b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        public RecyclerView.ItemAnimator.ItemHolderInfo f214305c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        public RecyclerView.ItemAnimator.ItemHolderInfo f214306d;

        /* renamed from: e, reason: collision with root package name */
        public int f214307e = 0;

        /* renamed from: f, reason: collision with root package name */
        public int f214308f = 0;

        /* renamed from: g, reason: collision with root package name */
        public int f214309g = 0;

        /* renamed from: h, reason: collision with root package name */
        public int f214310h = 0;

        public g(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
            this.f214303a = viewHolder;
            this.f214304b = viewHolder2;
            this.f214305c = itemHolderInfo;
            this.f214306d = itemHolderInfo2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface h {
        void a();

        void b();

        void c();

        void onAnimEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.ViewHolder f214311a;

        /* renamed from: b, reason: collision with root package name */
        public int f214312b;

        /* renamed from: c, reason: collision with root package name */
        public int f214313c;

        /* renamed from: d, reason: collision with root package name */
        public int f214314d;

        /* renamed from: e, reason: collision with root package name */
        public int f214315e;

        i(RecyclerView.ViewHolder viewHolder, int i3, int i16, int i17, int i18) {
            this.f214311a = viewHolder;
            this.f214312b = i3;
            this.f214313c = i16;
            this.f214314d = i17;
            this.f214315e = i18;
        }
    }

    public GuildChannelListAnim(h hVar, int i3) {
        this.f214288j = q(i3);
        setMoveDuration(300L);
        setChangeDuration(300L);
        setAddDuration(300L);
        setRemoveDuration(250L);
        this.f214284f = hVar;
    }

    private void m() {
        if (!this.f214279a.isEmpty() || !this.f214280b.isEmpty() || !this.f214281c.isEmpty() || !this.f214282d.isEmpty() || !this.f214283e.isEmpty()) {
            z("checkNoPendings: false");
        }
    }

    private boolean n(boolean z16) {
        if (this.f214283e.size() > 1) {
            z("error checkStateInvalid");
            endAnimations();
            return true;
        }
        if (!this.f214282d.isEmpty() && this.f214283e.size() > 0) {
            z("error checkStateInvalid mPendingChanges");
            endAnimations();
            return true;
        }
        if (!z16 || this.f214283e.get(0).f214304b != null) {
            return false;
        }
        QLog.e("Guild.MF.Rt.Anim.GuildChannelListAnim", 1, "unexpected mPendingChanges: " + this.f214282d.size());
        endAnimations();
        return true;
    }

    private Runnable o() {
        return new Runnable() { // from class: com.tencent.mobileqq.guild.animate.subchannellist.GuildChannelListAnim.5
            @Override // java.lang.Runnable
            public void run() {
                if (GuildChannelListAnim.this.isRunning()) {
                    QLog.e("Guild.MF.Rt.Anim.GuildChannelListAnim", 1, "\u5b50\u9891\u9053\u5217\u8868\u9996\u9875\u52a8\u753b\u672a\u6b63\u5e38\u7ed3\u675f:, mChangeAnimRunner: " + GuildChannelListAnim.this.f214288j.g() + ", mRemoveAnimRunner: " + GuildChannelListAnim.this.f214287i.g() + ", mMoveAnimRunner: " + GuildChannelListAnim.this.f214286h.h() + ", mAddAnimRunner: " + GuildChannelListAnim.this.f214285g.g());
                    QLog.w("Guild.MF.Rt.Anim.GuildChannelListAnim", 1, "mPendingAdditions:" + GuildChannelListAnim.this.f214280b.size() + ", mPendingMoves:" + GuildChannelListAnim.this.f214281c.size() + ", mPendingRemovals:" + GuildChannelListAnim.this.f214279a.size() + ", mPendingGroupChanges:" + GuildChannelListAnim.this.f214283e.size() + ", mPendingChanges:" + GuildChannelListAnim.this.f214282d.size());
                    GuildChannelListAnim.this.z("mDelayCheckAnimEnd");
                    GuildChannelListAnim.this.endAnimations();
                }
                GuildChannelListAnim.this.f214284f.onAnimEnd();
            }
        };
    }

    private com.tencent.mobileqq.guild.animate.subchannellist.a p() {
        return new com.tencent.mobileqq.guild.animate.subchannellist.a(f214277m, new a());
    }

    private we1.a q(int i3) {
        d dVar = new d();
        if (i3 == 1) {
            return new we1.c(f214277m, dVar);
        }
        if (i3 == 3) {
            return new we1.e(f214277m, dVar);
        }
        return new we1.g(f214277m, dVar);
    }

    private com.tencent.mobileqq.guild.animate.subchannellist.b r() {
        return new com.tencent.mobileqq.guild.animate.subchannellist.b(f214277m, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetAnimation(RecyclerView.ViewHolder viewHolder) {
        viewHolder.itemView.animate().setInterpolator(f214277m);
        endAnimation(viewHolder);
    }

    private void runMovePendingAnimations(boolean z16, boolean z17) {
        if (!z16 && !z17) {
            Iterator<i> it = this.f214281c.iterator();
            while (it.hasNext()) {
                i next = it.next();
                this.f214286h.e(next.f214311a, next.f214312b, next.f214313c, next.f214314d, next.f214315e);
            }
            this.f214281c.clear();
            return;
        }
        long moveDuration = getMoveDuration();
        if (z17) {
            moveDuration = getAddDuration();
        } else if (z16) {
            moveDuration = getRemoveDuration();
        }
        Iterator<i> it5 = this.f214281c.iterator();
        while (it5.hasNext()) {
            i next2 = it5.next();
            this.f214286h.d(next2.f214311a, next2.f214312b, next2.f214313c, next2.f214314d, next2.f214315e, moveDuration, 0L);
        }
        this.f214281c.clear();
    }

    @NonNull
    private com.tencent.mobileqq.guild.animate.subchannellist.c s() {
        return new com.tencent.mobileqq.guild.animate.subchannellist.c(f214277m, getRemoveDuration(), new c());
    }

    private void t(e eVar) {
        RecyclerView.ViewHolder viewHolder = eVar.f214296b;
        if (viewHolder != null) {
            v(eVar, viewHolder);
        }
        RecyclerView.ViewHolder viewHolder2 = eVar.f214295a;
        if (viewHolder2 != null) {
            v(eVar, viewHolder2);
        }
    }

    private void u(g gVar) {
        RecyclerView.ViewHolder viewHolder = gVar.f214304b;
        if (viewHolder != null) {
            w(gVar, viewHolder);
        }
        RecyclerView.ViewHolder viewHolder2 = gVar.f214303a;
        if (viewHolder2 != null) {
            w(gVar, viewHolder2);
        }
    }

    private boolean v(e eVar, RecyclerView.ViewHolder viewHolder) {
        boolean z16 = false;
        if (eVar.f214296b == viewHolder) {
            eVar.f214296b = null;
        } else {
            if (eVar.f214295a != viewHolder) {
                return false;
            }
            eVar.f214295a = null;
            z16 = true;
        }
        ViewCompat.setAlpha(viewHolder.itemView, 1.0f);
        ViewCompat.setTranslationX(viewHolder.itemView, 0.0f);
        ViewCompat.setTranslationY(viewHolder.itemView, 0.0f);
        dispatchChangeFinished(viewHolder, z16);
        return true;
    }

    private boolean w(g gVar, RecyclerView.ViewHolder viewHolder) {
        boolean z16 = false;
        if (gVar.f214304b == viewHolder) {
            gVar.f214304b = null;
        } else {
            if (gVar.f214303a != viewHolder) {
                return false;
            }
            gVar.f214303a = null;
            z16 = true;
        }
        ViewCompat.setAlpha(viewHolder.itemView, 1.0f);
        ViewCompat.setTranslationX(viewHolder.itemView, 0.0f);
        ViewCompat.setTranslationY(viewHolder.itemView, 0.0f);
        dispatchChangeFinished(viewHolder, z16);
        return true;
    }

    private void x() {
        int size = this.f214281c.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            i iVar = this.f214281c.get(size);
            View view = iVar.f214311a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            dispatchMoveFinished(iVar.f214311a);
            this.f214281c.remove(size);
        }
        for (int size2 = this.f214279a.size() - 1; size2 >= 0; size2--) {
            RecyclerView.ViewHolder viewHolder = this.f214279a.get(size2);
            viewHolder.itemView.setTranslationY(0.0f);
            viewHolder.itemView.setTranslationX(0.0f);
            dispatchRemoveFinished(viewHolder);
            this.f214279a.remove(size2);
        }
        for (int size3 = this.f214280b.size() - 1; size3 >= 0; size3--) {
            RecyclerView.ViewHolder viewHolder2 = this.f214280b.get(size3);
            viewHolder2.itemView.setTranslationY(0.0f);
            viewHolder2.itemView.setTranslationX(0.0f);
            viewHolder2.itemView.setAlpha(1.0f);
            dispatchAddFinished(viewHolder2);
            this.f214280b.remove(size3);
        }
        for (int size4 = this.f214282d.size() - 1; size4 >= 0; size4--) {
            t(this.f214282d.get(size4));
        }
        this.f214282d.clear();
        for (int size5 = this.f214283e.size() - 1; size5 >= 0; size5--) {
            u(this.f214283e.get(size5));
        }
        this.f214283e.clear();
    }

    private void y(boolean z16) {
        long removeDuration;
        float height = (this.f214283e.get(0).f214308f + this.f214283e.get(0).f214304b.itemView.getHeight()) - f214278n;
        Iterator<RecyclerView.ViewHolder> it = this.f214279a.iterator();
        while (it.hasNext()) {
            this.f214287i.d(it.next(), height);
        }
        this.f214279a.clear();
        Iterator<RecyclerView.ViewHolder> it5 = this.f214280b.iterator();
        while (it5.hasNext()) {
            this.f214285g.d(it5.next(), height, true, getAddDuration());
        }
        this.f214280b.clear();
        Iterator<g> it6 = this.f214283e.iterator();
        while (it6.hasNext()) {
            g next = it6.next();
            we1.a aVar = this.f214288j;
            if (z16) {
                removeDuration = getAddDuration();
            } else {
                removeDuration = getRemoveDuration();
            }
            aVar.c(next, removeDuration);
        }
        this.f214283e.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str) {
        if (QLog.isColorLevel()) {
            QLog.i("Guild.MF.Rt.Anim.GuildChannelListAnim", 1, str + " remove: " + this.f214279a.size() + " add: " + this.f214280b.size() + " move: " + this.f214281c.size() + " change: " + this.f214282d.size() + " groupChange: " + this.f214283e.size());
        }
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateAdd(RecyclerView.ViewHolder viewHolder) {
        resetAnimation(viewHolder);
        RecyclerView.ViewHolder c16 = this.f214285g.c(viewHolder);
        if (c16 == null) {
            dispatchAddFinished(viewHolder);
            return false;
        }
        c16.itemView.setAlpha(0.0f);
        this.f214280b.add(c16);
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean animateChange(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        resetAnimation(viewHolder);
        resetAnimation(viewHolder2);
        g a16 = this.f214288j.a(viewHolder, viewHolder2, itemHolderInfo, itemHolderInfo2);
        if (a16 == null) {
            return super.animateChange(viewHolder, viewHolder2, itemHolderInfo, itemHolderInfo2);
        }
        this.f214283e.add(a16);
        return super.animateChange(viewHolder, viewHolder2, itemHolderInfo, itemHolderInfo2);
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateMove(RecyclerView.ViewHolder viewHolder, int i3, int i16, int i17, int i18) {
        RecyclerView.ViewHolder c16 = this.f214286h.c(viewHolder, i3, i16, i17, i18);
        if (c16 == null) {
            dispatchMoveFinished(viewHolder);
            return false;
        }
        int translationX = i3 + ((int) c16.itemView.getTranslationX());
        int translationY = i16 + ((int) c16.itemView.getTranslationY());
        resetAnimation(c16);
        int i19 = i17 - translationX;
        int i26 = i18 - translationY;
        if (i19 == 0 && i26 == 0) {
            dispatchMoveFinished(c16);
            return false;
        }
        if (i19 != 0) {
            c16.itemView.setTranslationX(-i19);
        }
        if (i26 != 0) {
            c16.itemView.setTranslationY(-i26);
        }
        this.f214281c.add(new i(c16, translationX, translationY, i17, i18));
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateRemove(RecyclerView.ViewHolder viewHolder) {
        resetAnimation(viewHolder);
        RecyclerView.ViewHolder c16 = this.f214287i.c(viewHolder);
        if (c16 == null) {
            dispatchRemoveFinished(viewHolder);
            return false;
        }
        this.f214279a.add(c16);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull List<Object> list) {
        if (!list.isEmpty()) {
            if (!super.canReuseUpdatedViewHolder(viewHolder)) {
                QLog.d("Guild.MF.Rt.Anim.GuildChannelListAnim", 4, "canReuseUpdatedViewHolder forceReuse" + viewHolder);
                return true;
            }
            return true;
        }
        return super.canReuseUpdatedViewHolder(viewHolder, list);
    }

    void dispatchFinishedWhenDone() {
        if (!isRunning()) {
            dispatchAnimationsFinished();
            this.f214284f.onAnimEnd();
            this.f214289k.removeCallbacks(this.f214290l);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimation(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        view.animate().cancel();
        this.f214288j.e(viewHolder);
        for (int size = this.f214281c.size() - 1; size >= 0; size--) {
            if (this.f214281c.get(size).f214311a == viewHolder) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                dispatchMoveFinished(viewHolder);
                this.f214281c.remove(size);
            }
        }
        if (this.f214279a.remove(viewHolder)) {
            view.setAlpha(1.0f);
            dispatchRemoveFinished(viewHolder);
        }
        if (this.f214280b.remove(viewHolder)) {
            view.setAlpha(1.0f);
            dispatchAddFinished(viewHolder);
        }
        for (int size2 = this.f214282d.size() - 1; size2 >= 0; size2--) {
            e eVar = this.f214282d.get(size2);
            if (v(eVar, viewHolder) && eVar.f214295a == null && eVar.f214296b == null) {
                this.f214282d.remove(eVar);
            }
        }
        for (int size3 = this.f214283e.size() - 1; size3 >= 0; size3--) {
            g gVar = this.f214283e.get(size3);
            if (w(gVar, viewHolder) && gVar.f214303a == null && gVar.f214304b == null) {
                this.f214283e.remove(size3);
            }
        }
        if (QLog.isDebugVersion()) {
            this.f214285g.e(viewHolder);
            this.f214286h.f(viewHolder);
            this.f214288j.d(viewHolder);
            this.f214287i.e(viewHolder);
        }
        dispatchFinishedWhenDone();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimations() {
        if (QLog.isColorLevel()) {
            QLog.i("Guild.MF.Rt.Anim.GuildChannelListAnim", 1, "endAnimations");
        }
        x();
        if (!isRunning()) {
            dispatchAnimationsFinished();
            dispatchFinishedWhenDone();
            return;
        }
        this.f214287i.f();
        this.f214286h.g();
        this.f214285g.f();
        this.f214288j.f();
        dispatchAnimationsFinished();
        dispatchFinishedWhenDone();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean isRunning() {
        if (this.f214280b.isEmpty() && this.f214281c.isEmpty() && this.f214279a.isEmpty() && this.f214283e.isEmpty() && this.f214282d.isEmpty() && !this.f214285g.g() && !this.f214286h.h() && !this.f214287i.g() && !this.f214288j.g()) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    @NonNull
    public RecyclerView.ItemAnimator.ItemHolderInfo obtainHolderInfo() {
        return new f();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    @NonNull
    public RecyclerView.ItemAnimator.ItemHolderInfo recordPostLayoutInformation(@NonNull RecyclerView.State state, @NonNull RecyclerView.ViewHolder viewHolder) {
        return super.recordPostLayoutInformation(state, viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    @NonNull
    public RecyclerView.ItemAnimator.ItemHolderInfo recordPreLayoutInformation(@NonNull RecyclerView.State state, @NonNull RecyclerView.ViewHolder viewHolder, int i3, @NonNull List<Object> list) {
        RecyclerView.ItemAnimator.ItemHolderInfo recordPreLayoutInformation = super.recordPreLayoutInformation(state, viewHolder, i3, list);
        if (i3 != 2) {
            return recordPreLayoutInformation;
        }
        if (!(recordPreLayoutInformation instanceof f)) {
            return recordPreLayoutInformation;
        }
        f fVar = (f) recordPreLayoutInformation;
        List<Integer> a16 = com.tencent.mobileqq.guild.main.data.b.a(list);
        if (a16.contains(2)) {
            fVar.f214301a = true;
        } else if (a16.contains(3)) {
            fVar.f214302b = true;
        }
        return fVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void runPendingAnimations() {
        boolean z16 = !this.f214279a.isEmpty();
        boolean z17 = !this.f214281c.isEmpty();
        boolean z18 = !this.f214280b.isEmpty();
        boolean z19 = !this.f214282d.isEmpty();
        boolean z26 = !this.f214283e.isEmpty();
        if (!z16 && !z17 && !z18 && !z19 && !z26) {
            return;
        }
        if (n(z26)) {
            QLog.i("Guild.MF.Rt.Anim.GuildChannelListAnim", 1, "runPendingAnimations checkStateInvalid(groupChangePending)");
            endAnimations();
            return;
        }
        if (!z26) {
            QLog.i("Guild.MF.Rt.Anim.GuildChannelListAnim", 2, "runPendingAnimations but no need runPendingAnimations for biz");
            endAnimations();
            return;
        }
        z("runPendingAnimations");
        this.f214284f.a();
        this.f214289k.removeCallbacks(this.f214290l);
        this.f214289k.postDelayed(this.f214290l, 1000L);
        if (z26) {
            y(z18);
        }
        runMovePendingAnimations(z16, z18);
        m();
        dispatchFinishedWhenDone();
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.ViewHolder f214295a;

        /* renamed from: b, reason: collision with root package name */
        public RecyclerView.ViewHolder f214296b;

        /* renamed from: c, reason: collision with root package name */
        public int f214297c;

        /* renamed from: d, reason: collision with root package name */
        public int f214298d;

        /* renamed from: e, reason: collision with root package name */
        public int f214299e;

        /* renamed from: f, reason: collision with root package name */
        public int f214300f;

        public e(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            this.f214295a = viewHolder;
            this.f214296b = viewHolder2;
        }

        public e(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i3, int i16, int i17, int i18) {
            this(viewHolder, viewHolder2);
            this.f214297c = i3;
            this.f214298d = i16;
            this.f214299e = i17;
            this.f214300f = i18;
        }
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateChange(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i3, int i16, int i17, int i18) {
        return this.f214288j.b(viewHolder, viewHolder2, i3, i16, i17, i18, this.f214282d, this.f214283e);
    }
}
