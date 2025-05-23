package com.tencent.mobileqq.troop.adapter;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.cmd0x9fb.oidb_0x9fb$Label;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0007J\f\u0010\u0006\u001a\u00020\u0005*\u00020\u0002H\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troop/adapter/d;", "", "Lcom/tencent/mobileqq/troop/recommend/data/RecommendTroopItem;", "", "a", "", "b", "<init>", "()V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f293810a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23172);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f293810a = new d();
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final int a(@NotNull RecommendTroopItem recommendTroopItem) {
        Intrinsics.checkNotNullParameter(recommendTroopItem, "<this>");
        List<oidb_0x9fb$Label> list = recommendTroopItem.stateList;
        if (list != null) {
            for (oidb_0x9fb$Label oidb_0x9fb_label : list) {
                if (oidb_0x9fb_label.enum_type.get() == 24) {
                    return oidb_0x9fb_label.uint32_label_attr.get();
                }
            }
            return 0;
        }
        return 0;
    }

    @JvmStatic
    public static final boolean b(@NotNull RecommendTroopItem recommendTroopItem) {
        Intrinsics.checkNotNullParameter(recommendTroopItem, "<this>");
        if (a(recommendTroopItem) == 1) {
            return true;
        }
        return false;
    }
}
