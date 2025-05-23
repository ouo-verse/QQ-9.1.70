package com.tencent.mobileqq.qqlive.sail.ui;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u0007J\b\u0010\f\u001a\u0004\u0018\u00010\u0003J\b\u0010\r\u001a\u00020\u0007H\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0007H\u0016R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0011\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/h;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "", "Lqr4/b;", "appendFeeds", "", "d", "", "currentPos", "e", "position", "f", "g", "getCount", "Landroidx/fragment/app/Fragment;", "getItem", "", "Ljava/util/List;", "feeds", "Landroidx/fragment/app/FragmentManager;", "fm", "<init>", "(Landroidx/fragment/app/FragmentManager;)V", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class h extends FragmentStatePagerAdapter {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<qr4.b> feeds;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/h$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.h$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51393);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NotNull FragmentManager fm5) {
        super(fm5);
        Intrinsics.checkNotNullParameter(fm5, "fm");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fm5);
        } else {
            this.feeds = new ArrayList();
        }
    }

    public final void d(@NotNull List<qr4.b> appendFeeds) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appendFeeds);
            return;
        }
        Intrinsics.checkNotNullParameter(appendFeeds, "appendFeeds");
        AegisLogger.INSTANCE.i("Audience|QQLiveRoomListAdapter", "updateFeeds", "append feeds size=" + appendFeeds.size());
        if (appendFeeds.isEmpty()) {
            return;
        }
        this.feeds.addAll(appendFeeds);
        notifyDataSetChanged();
    }

    public final void e(int currentPos) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, currentPos);
        } else {
            if (currentPos >= this.feeds.size()) {
                return;
            }
            qr4.b bVar = this.feeds.get(currentPos);
            this.feeds.clear();
            this.feeds.add(bVar);
            notifyDataSetChanged();
        }
    }

    @Nullable
    public final qr4.b f(int position) {
        Object orNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(this.feeds, position);
            return (qr4.b) orNull;
        }
        return (qr4.b) iPatchRedirector.redirect((short) 4, (Object) this, position);
    }

    @Nullable
    public final qr4.b g() {
        Object lastOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) this.feeds);
            return (qr4.b) lastOrNull;
        }
        return (qr4.b) iPatchRedirector.redirect((short) 5, (Object) this);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.feeds.size();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    @NotNull
    public Fragment getItem(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Fragment) iPatchRedirector.redirect((short) 7, (Object) this, position);
        }
        QQLiveAudienceRoomFragment qQLiveAudienceRoomFragment = new QQLiveAudienceRoomFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("key_feed_position", position);
        bundle.putByteArray("key_feed_bytes", com.tencent.mobileqq.qqlive.sail.model.c.d(this.feeds.get(position)));
        qQLiveAudienceRoomFragment.setArguments(bundle);
        return qQLiveAudienceRoomFragment;
    }
}
