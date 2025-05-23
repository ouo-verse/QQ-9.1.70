package com.tencent.guild.aio.component.combinestyle;

import android.view.View;
import androidx.annotation.DrawableRes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b-\u0010.J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\f\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0013J<\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00162,\b\u0002\u0010\u001a\u001a&\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0018j\u0012\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001`\u0019J\u0006\u0010\u001d\u001a\u00020\u001cR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010 R\u0016\u0010#\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\"R:\u0010%\u001a&\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0018j\u0012\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001`\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010$R\u0016\u0010'\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010&R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010(R\u0016\u0010*\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010(R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010+R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010,R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010&\u00a8\u0006/"}, d2 = {"Lcom/tencent/guild/aio/component/combinestyle/y;", "", "", "itemStyleType", "j", "Landroid/view/View$OnClickListener;", "itemOnClickListener", "g", "Landroid/view/View$OnLongClickListener;", "itemOnLongClickListener", tl.h.F, "itemBgRes", "d", "", "enableScrollUp", "c", "Lcom/tencent/guild/aio/component/combinestyle/ac;", "mediaAioComponent", "a", "Lcom/tencent/guild/aio/component/combinestyle/ad;", "componentIntercept", "b", "", "elementId", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "paramMap", "e", "Lcom/tencent/guild/aio/component/combinestyle/i;", "i", "", "Lcom/tencent/guild/aio/component/combinestyle/z;", "Ljava/util/List;", "iGuildMediaAioComponents", "Ljava/lang/String;", "reportElementId", "Ljava/util/HashMap;", "reportItemParamMap", "I", "bgRes", "Z", "f", "enableListenerMemberRoleChanged", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "<init>", "()V", "aio-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class y {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private HashMap<String, Object> reportItemParamMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean enableListenerMemberRoleChanged;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View.OnClickListener itemOnClickListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View.OnLongClickListener itemOnLongClickListener;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<z> iGuildMediaAioComponents = new ArrayList();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String reportElementId = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int bgRes = -1;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean enableScrollUp = true;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int itemStyleType = f.f110215a.b();

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ y f(y yVar, String str, HashMap hashMap, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            hashMap = null;
        }
        return yVar.e(str, hashMap);
    }

    @NotNull
    public final y a(@NotNull ac mediaAioComponent) {
        Intrinsics.checkNotNullParameter(mediaAioComponent, "mediaAioComponent");
        this.iGuildMediaAioComponents.add(mediaAioComponent);
        return this;
    }

    @NotNull
    public final y b(@NotNull ad componentIntercept) {
        Intrinsics.checkNotNullParameter(componentIntercept, "componentIntercept");
        this.iGuildMediaAioComponents.add(componentIntercept);
        return this;
    }

    @NotNull
    public final y c(boolean enableScrollUp) {
        this.enableScrollUp = enableScrollUp;
        return this;
    }

    @NotNull
    public final y d(@DrawableRes int itemBgRes) {
        this.bgRes = itemBgRes;
        return this;
    }

    @NotNull
    public final y e(@NotNull String elementId, @Nullable HashMap<String, Object> paramMap) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        this.reportElementId = elementId;
        this.reportItemParamMap = paramMap;
        return this;
    }

    @NotNull
    public final y g(@NotNull View.OnClickListener itemOnClickListener) {
        Intrinsics.checkNotNullParameter(itemOnClickListener, "itemOnClickListener");
        this.itemOnClickListener = itemOnClickListener;
        return this;
    }

    @NotNull
    public final y h(@NotNull View.OnLongClickListener itemOnLongClickListener) {
        Intrinsics.checkNotNullParameter(itemOnLongClickListener, "itemOnLongClickListener");
        this.itemOnLongClickListener = itemOnLongClickListener;
        return this;
    }

    @NotNull
    public final GuildMediaAioCombineStyleChain i() {
        return new GuildMediaAioCombineStyleChain(this.iGuildMediaAioComponents, this.reportElementId, this.reportItemParamMap, null, this.enableScrollUp, null, this.bgRes, this.itemOnClickListener, this.itemOnLongClickListener, this.enableListenerMemberRoleChanged, this.itemStyleType, 40, null);
    }

    @NotNull
    public final y j(int itemStyleType) {
        this.itemStyleType = itemStyleType;
        return this;
    }
}
