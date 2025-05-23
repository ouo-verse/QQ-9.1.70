package com.tencent.guild.aio.component.combinestyle;

import android.os.Bundle;
import android.view.View;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u00a1\u0001\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012*\u0010\u001a\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0014j\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001`\u0015\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001b\u0012\b\b\u0002\u0010\"\u001a\u00020\u0007\u0012\b\b\u0002\u0010(\u001a\u00020#\u0012\b\b\u0002\u0010,\u001a\u00020\u0004\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010-\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000102\u0012\b\b\u0002\u00107\u001a\u00020\u0007\u0012\b\b\u0002\u00109\u001a\u00020\u0004\u00a2\u0006\u0004\b:\u0010;J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R;\u0010\u001a\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0014j\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001`\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001e\u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b\u000f\u0010\u001dR\u0017\u0010\"\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001f\u0010!R\u0017\u0010(\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010,\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b\u0016\u0010+R\u0019\u00101\u001a\u0004\u0018\u00010-8\u0006\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b$\u00100R\u0019\u00105\u001a\u0004\u0018\u0001028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u00103\u001a\u0004\b)\u00104R\u0017\u00107\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b6\u0010 \u001a\u0004\b6\u0010!R\u0017\u00109\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b8\u0010*\u001a\u0004\b.\u0010+\u00a8\u0006<"}, d2 = {"Lcom/tencent/guild/aio/component/combinestyle/i;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lcom/tencent/guild/aio/component/combinestyle/z;", "a", "Ljava/util/List;", "()Ljava/util/List;", "aioComponents", "b", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "elementId", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "c", "Ljava/util/HashMap;", "i", "()Ljava/util/HashMap;", "paramMap", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/IMsgListRepository$MsgListRepoOpType;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/IMsgListRepository$MsgListRepoOpType;", "()Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/IMsgListRepository$MsgListRepoOpType;", "aioListOpType", "e", "Z", "()Z", "enableScrollUp", "Landroid/os/Bundle;", "f", "Landroid/os/Bundle;", "getBundle", "()Landroid/os/Bundle;", "bundle", "g", "I", "()I", "bgRes", "Landroid/view/View$OnClickListener;", tl.h.F, "Landroid/view/View$OnClickListener;", "()Landroid/view/View$OnClickListener;", "itemOnClickListener", "Landroid/view/View$OnLongClickListener;", "Landroid/view/View$OnLongClickListener;", "()Landroid/view/View$OnLongClickListener;", "itemOnLongClickListener", "j", "isNeedListenerMemberRoleChanged", "k", "itemStyleType", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/util/HashMap;Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/IMsgListRepository$MsgListRepoOpType;ZLandroid/os/Bundle;ILandroid/view/View$OnClickListener;Landroid/view/View$OnLongClickListener;ZI)V", "aio-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.guild.aio.component.combinestyle.i, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class GuildMediaAioCombineStyleChain {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<z> aioComponents;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String elementId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final HashMap<String, Object> paramMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final IMsgListRepository.MsgListRepoOpType aioListOpType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean enableScrollUp;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Bundle bundle;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final int bgRes;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final View.OnClickListener itemOnClickListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final View.OnLongClickListener itemOnLongClickListener;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isNeedListenerMemberRoleChanged;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private final int itemStyleType;

    public GuildMediaAioCombineStyleChain(@NotNull List<z> aioComponents, @Nullable String str, @Nullable HashMap<String, Object> hashMap, @NotNull IMsgListRepository.MsgListRepoOpType aioListOpType, boolean z16, @NotNull Bundle bundle, int i3, @Nullable View.OnClickListener onClickListener, @Nullable View.OnLongClickListener onLongClickListener, boolean z17, int i16) {
        Intrinsics.checkNotNullParameter(aioComponents, "aioComponents");
        Intrinsics.checkNotNullParameter(aioListOpType, "aioListOpType");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        this.aioComponents = aioComponents;
        this.elementId = str;
        this.paramMap = hashMap;
        this.aioListOpType = aioListOpType;
        this.enableScrollUp = z16;
        this.bundle = bundle;
        this.bgRes = i3;
        this.itemOnClickListener = onClickListener;
        this.itemOnLongClickListener = onLongClickListener;
        this.isNeedListenerMemberRoleChanged = z17;
        this.itemStyleType = i16;
    }

    @NotNull
    public final List<z> a() {
        return this.aioComponents;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final IMsgListRepository.MsgListRepoOpType getAioListOpType() {
        return this.aioListOpType;
    }

    /* renamed from: c, reason: from getter */
    public final int getBgRes() {
        return this.bgRes;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final String getElementId() {
        return this.elementId;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getEnableScrollUp() {
        return this.enableScrollUp;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildMediaAioCombineStyleChain)) {
            return false;
        }
        GuildMediaAioCombineStyleChain guildMediaAioCombineStyleChain = (GuildMediaAioCombineStyleChain) other;
        if (Intrinsics.areEqual(this.aioComponents, guildMediaAioCombineStyleChain.aioComponents) && Intrinsics.areEqual(this.elementId, guildMediaAioCombineStyleChain.elementId) && Intrinsics.areEqual(this.paramMap, guildMediaAioCombineStyleChain.paramMap) && this.aioListOpType == guildMediaAioCombineStyleChain.aioListOpType && this.enableScrollUp == guildMediaAioCombineStyleChain.enableScrollUp && Intrinsics.areEqual(this.bundle, guildMediaAioCombineStyleChain.bundle) && this.bgRes == guildMediaAioCombineStyleChain.bgRes && Intrinsics.areEqual(this.itemOnClickListener, guildMediaAioCombineStyleChain.itemOnClickListener) && Intrinsics.areEqual(this.itemOnLongClickListener, guildMediaAioCombineStyleChain.itemOnLongClickListener) && this.isNeedListenerMemberRoleChanged == guildMediaAioCombineStyleChain.isNeedListenerMemberRoleChanged && this.itemStyleType == guildMediaAioCombineStyleChain.itemStyleType) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final View.OnClickListener getItemOnClickListener() {
        return this.itemOnClickListener;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final View.OnLongClickListener getItemOnLongClickListener() {
        return this.itemOnLongClickListener;
    }

    /* renamed from: h, reason: from getter */
    public final int getItemStyleType() {
        return this.itemStyleType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4 = this.aioComponents.hashCode() * 31;
        String str = this.elementId;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (hashCode4 + hashCode) * 31;
        HashMap<String, Object> hashMap = this.paramMap;
        if (hashMap == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = hashMap.hashCode();
        }
        int hashCode5 = (((i16 + hashCode2) * 31) + this.aioListOpType.hashCode()) * 31;
        boolean z16 = this.enableScrollUp;
        int i17 = 1;
        int i18 = z16;
        if (z16 != 0) {
            i18 = 1;
        }
        int hashCode6 = (((((hashCode5 + i18) * 31) + this.bundle.hashCode()) * 31) + this.bgRes) * 31;
        View.OnClickListener onClickListener = this.itemOnClickListener;
        if (onClickListener == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = onClickListener.hashCode();
        }
        int i19 = (hashCode6 + hashCode3) * 31;
        View.OnLongClickListener onLongClickListener = this.itemOnLongClickListener;
        if (onLongClickListener != null) {
            i3 = onLongClickListener.hashCode();
        }
        int i26 = (i19 + i3) * 31;
        boolean z17 = this.isNeedListenerMemberRoleChanged;
        if (!z17) {
            i17 = z17 ? 1 : 0;
        }
        return ((i26 + i17) * 31) + this.itemStyleType;
    }

    @Nullable
    public final HashMap<String, Object> i() {
        return this.paramMap;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getIsNeedListenerMemberRoleChanged() {
        return this.isNeedListenerMemberRoleChanged;
    }

    @NotNull
    public String toString() {
        return "GuildMediaAioCombineStyleChain(aioComponents=" + this.aioComponents + ", elementId=" + this.elementId + ", paramMap=" + this.paramMap + ", aioListOpType=" + this.aioListOpType + ", enableScrollUp=" + this.enableScrollUp + ", bundle=" + this.bundle + ", bgRes=" + this.bgRes + ", itemOnClickListener=" + this.itemOnClickListener + ", itemOnLongClickListener=" + this.itemOnLongClickListener + ", isNeedListenerMemberRoleChanged=" + this.isNeedListenerMemberRoleChanged + ", itemStyleType=" + this.itemStyleType + ")";
    }

    public /* synthetic */ GuildMediaAioCombineStyleChain(List list, String str, HashMap hashMap, IMsgListRepository.MsgListRepoOpType msgListRepoOpType, boolean z16, Bundle bundle, int i3, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener, boolean z17, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? new ArrayList() : list, str, hashMap, (i17 & 8) != 0 ? IMsgListRepository.MsgListRepoOpType.OtherOperation : msgListRepoOpType, (i17 & 16) != 0 ? true : z16, (i17 & 32) != 0 ? new Bundle() : bundle, (i17 & 64) != 0 ? -1 : i3, (i17 & 128) != 0 ? null : onClickListener, (i17 & 256) != 0 ? null : onLongClickListener, (i17 & 512) != 0 ? false : z17, (i17 & 1024) != 0 ? f.f110215a.b() : i16);
    }
}
