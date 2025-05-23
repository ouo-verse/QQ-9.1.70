package com.tencent.qqnt.chats.main.ui.processor;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.IPublicAccountPluginApi;
import com.tencent.qqnt.aio.utils.af;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.view.RollingTextView;
import com.tencent.theme.SkinnableBitmapDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0007H\u0002J \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/chats/main/ui/processor/a;", "Lcom/tencent/qqnt/chats/inject/unread/a;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "c", "b", "", "chatType", "e", "pageType", "d", "Lcom/tencent/qqnt/chats/view/RollingTextView;", "view", "Landroid/widget/ImageView;", "summaryRightView", "", "a", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a extends com.tencent.qqnt.chats.inject.unread.a {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean b(g item) {
        if (item.n() == 16 && ex3.a.k(item.s()) != 0) {
            return true;
        }
        return false;
    }

    private final boolean c(g item) {
        if (item.n() == 16) {
            return true;
        }
        return false;
    }

    private final boolean d(int pageType) {
        if (pageType == 1 || pageType == 9) {
            return false;
        }
        return true;
    }

    private final boolean e(int chatType) {
        if (chatType == 1 || chatType == 2 || chatType == 16 || chatType == 62) {
            return false;
        }
        if (chatType != 103) {
            if (chatType == 105 || chatType == 116 || chatType == 118 || chatType == 201) {
                return false;
            }
        } else if (((IPublicAccountPluginApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IPublicAccountPluginApi.class)).runTimePublicAccountPluginSwitch()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.chats.inject.unread.a
    public void a(@NotNull g item, @NotNull RollingTextView view, @NotNull ImageView summaryRightView) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, item, view, summaryRightView);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(summaryRightView, "summaryRightView");
        if (!e(item.n()) && !d(item.o())) {
            if (c(item)) {
                z16 = b(item);
            } else if (item.x().c() == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                Drawable a16 = af.a(ResourcesCompat.getDrawable(summaryRightView.getResources(), R.drawable.qui_remind_mute_new, null));
                if (a16 != null) {
                    if (a16 instanceof SkinnableBitmapDrawable) {
                        ((SkinnableBitmapDrawable) a16).mutate2();
                    } else {
                        a16.mutate();
                    }
                }
                if (a16 != null) {
                    a16.setColorFilter(new PorterDuffColorFilter(ie0.a.f().g(summaryRightView.getContext(), R.color.qui_common_fill_standard_quaternary, 1000), PorterDuff.Mode.SRC_IN));
                    summaryRightView.setImageDrawable(a16);
                    summaryRightView.setTag(R.id.f907853e, 1);
                    summaryRightView.setVisibility(0);
                    return;
                }
                return;
            }
            summaryRightView.setImageDrawable(null);
            summaryRightView.setVisibility(8);
            return;
        }
        summaryRightView.setImageDrawable(null);
        summaryRightView.setVisibility(8);
    }
}
