package com.tencent.mobileqq.sharepanel.config.biz;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\f\u0018\u00002\u00020\u0001BQ\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\b\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\b\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\b\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\b\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u0003\u0010\u000bR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000f\u0010\u000bR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/config/biz/c;", "", "", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", WadlProxyConsts.SCENE_ID, "", "b", "Ljava/util/List;", "()Ljava/util/List;", "channels", "c", "actions", "d", "modifiableChannels", "modifiableActions", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String sceneId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> channels;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> actions;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> modifiableChannels;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> modifiableActions;

    public c() {
        this(null, null, null, null, null, 31, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this);
    }

    @NotNull
    public final List<String> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.actions;
    }

    @NotNull
    public final List<String> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.channels;
    }

    @NotNull
    public final List<String> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.modifiableActions;
    }

    @NotNull
    public final List<String> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.modifiableChannels;
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.sceneId;
    }

    public c(@NotNull String sceneId, @NotNull List<String> channels, @NotNull List<String> actions, @NotNull List<String> modifiableChannels, @NotNull List<String> modifiableActions) {
        Intrinsics.checkNotNullParameter(sceneId, "sceneId");
        Intrinsics.checkNotNullParameter(channels, "channels");
        Intrinsics.checkNotNullParameter(actions, "actions");
        Intrinsics.checkNotNullParameter(modifiableChannels, "modifiableChannels");
        Intrinsics.checkNotNullParameter(modifiableActions, "modifiableActions");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, sceneId, channels, actions, modifiableChannels, modifiableActions);
            return;
        }
        this.sceneId = sceneId;
        this.channels = channels;
        this.actions = actions;
        this.modifiableChannels = modifiableChannels;
        this.modifiableActions = modifiableActions;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ c(String str, List list, List list2, List list3, List list4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(r2, r3, r4, r5, r6);
        List list5;
        List list6;
        List list7;
        List list8;
        List emptyList;
        List emptyList2;
        List emptyList3;
        List emptyList4;
        String str2 = (i3 & 1) != 0 ? "" : str;
        if ((i3 & 2) != 0) {
            emptyList4 = CollectionsKt__CollectionsKt.emptyList();
            list5 = emptyList4;
        } else {
            list5 = list;
        }
        if ((i3 & 4) != 0) {
            emptyList3 = CollectionsKt__CollectionsKt.emptyList();
            list6 = emptyList3;
        } else {
            list6 = list2;
        }
        if ((i3 & 8) != 0) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            list7 = emptyList2;
        } else {
            list7 = list3;
        }
        if ((i3 & 16) != 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list8 = emptyList;
        } else {
            list8 = list4;
        }
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, list, list2, list3, list4, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
