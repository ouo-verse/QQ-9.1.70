package com.tencent.mobileqq.guild.media.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \r2\u00020\u0001:\u0001\tB\u001d\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0014\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0014R*\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00108\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/GuildMediaMoreUserViewBase;", "Landroid/widget/FrameLayout;", "", "e", "", "b", "", "Lcom/tencent/mobileqq/guild/media/core/data/p;", "userInfoList", "a", "index", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "avatarView", "f", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/media/widget/a;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "mUserAvatarDataList", "", "Lkotlin/Lazy;", "c", "()Ljava/lang/String;", "mGuildId", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public class GuildMediaMoreUserViewBase extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<AvatarData> mUserAvatarDataList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mGuildId;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMediaMoreUserViewBase(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final String c() {
        return (String) this.mGuildId.getValue();
    }

    public final void a(@NotNull List<? extends com.tencent.mobileqq.guild.media.core.data.p> userInfoList) {
        boolean z16;
        Intrinsics.checkNotNullParameter(userInfoList, "userInfoList");
        com.tencent.mobileqq.guild.media.core.w.c("GuildMediaMoreUserViewBase_addAvatarsByUserInfoList");
        this.mUserAvatarDataList.clear();
        int size = userInfoList.size();
        HashSet hashSet = new HashSet();
        for (int i3 = 0; i3 < size; i3++) {
            com.tencent.mobileqq.guild.media.core.data.p pVar = userInfoList.get(i3);
            String str = pVar.f228093a;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16 && !hashSet.contains(pVar.f228093a)) {
                ArrayList<AvatarData> arrayList = this.mUserAvatarDataList;
                String str2 = pVar.f228093a;
                Intrinsics.checkNotNullExpressionValue(str2, "userInfo.id");
                String str3 = pVar.f228096d;
                Intrinsics.checkNotNullExpressionValue(str3, "userInfo.avatarMeta");
                arrayList.add(new AvatarData(str2, str3));
                hashSet.add(pVar.f228093a);
                if (this.mUserAvatarDataList.size() >= e()) {
                    break;
                }
            }
        }
        b();
        com.tencent.mobileqq.guild.media.core.w.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final ArrayList<AvatarData> d() {
        return this.mUserAvatarDataList;
    }

    protected int e() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(int index, @NotNull GuildUserAvatarView avatarView) {
        Intrinsics.checkNotNullParameter(avatarView, "avatarView");
        if (index >= this.mUserAvatarDataList.size()) {
            QLog.w("QGMC.GuildMediaMoreUserViewBase", 1, "[loadAvatarUrl2View] IndexOutOfBoundsException. ignored");
            return;
        }
        AvatarData avatarData = this.mUserAvatarDataList.get(index);
        Intrinsics.checkNotNullExpressionValue(avatarData, "mUserAvatarDataList[index]");
        AvatarData avatarData2 = avatarData;
        avatarView.setLogTag("QGMC.GuildMediaMoreUserViewBase_" + avatarData2.getTinyId());
        avatarView.setAvatarMeta(c(), avatarData2.getTinyId(), avatarData2.getAvatarMeta());
    }

    public /* synthetic */ GuildMediaMoreUserViewBase(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMediaMoreUserViewBase(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.mUserAvatarDataList = new ArrayList<>();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.guild.media.widget.GuildMediaMoreUserViewBase$mGuildId$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return com.tencent.mobileqq.guild.media.core.j.a().getGuildID();
            }
        });
        this.mGuildId = lazy;
    }

    protected void b() {
    }
}
