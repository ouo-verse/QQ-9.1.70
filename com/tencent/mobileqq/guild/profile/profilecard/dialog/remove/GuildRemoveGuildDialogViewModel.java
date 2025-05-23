package com.tencent.mobileqq.guild.profile.profilecard.dialog.remove;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.base.b;
import com.tencent.mobileqq.guild.profile.profilecard.dialog.remove.GuildRemoveGuildDialogViewModel;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.h;
import com.tencent.mobileqq.widget.listitem.x;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wy1.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0006\u0010\f\u001a\u00020\u0003J\u0016\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0003R\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/profile/profilecard/dialog/remove/GuildRemoveGuildDialogViewModel;", "Lcom/tencent/mobileqq/guild/base/b;", "Lwy1/a;", "", "itemId", "curSelectItemId", "", "getIsSelected", "Landroid/os/Bundle;", "bundle", "", "init", "getMsgRevokeType", "", "topDescription", "Lcom/tencent/mobileqq/widget/listitem/Group;", "getRemoveDialogListConfig", "Landroidx/lifecycle/MutableLiveData;", "curSelectItemLiveData", "Landroidx/lifecycle/MutableLiveData;", "getCurSelectItemLiveData", "()Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/guild/profile/profilecard/dialog/remove/RemoveFromGuildData;", "mData", "Lcom/tencent/mobileqq/guild/profile/profilecard/dialog/remove/RemoveFromGuildData;", "getMData", "()Lcom/tencent/mobileqq/guild/profile/profilecard/dialog/remove/RemoveFromGuildData;", "setMData", "(Lcom/tencent/mobileqq/guild/profile/profilecard/dialog/remove/RemoveFromGuildData;)V", "repository", "<init>", "(Lwy1/a;)V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildRemoveGuildDialogViewModel extends b<a> {
    public static final int ITEM_ID_DELETE_30_DAYS = 2;
    public static final int ITEM_ID_DELETE_7_DAYS = 1;
    public static final int ITEM_ID_DELETE_ALL = 3;
    public static final int ITEM_ID_EMPTY = 0;

    @NotNull
    private final MutableLiveData<Integer> curSelectItemLiveData;
    public RemoveFromGuildData mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRemoveGuildDialogViewModel(@NotNull a repository) {
        super(repository);
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.curSelectItemLiveData = new MutableLiveData<>();
    }

    private final boolean getIsSelected(int itemId, int curSelectItemId) {
        if (itemId == curSelectItemId) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getRemoveDialogListConfig$lambda$0(GuildRemoveGuildDialogViewModel this$0, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        this$0.curSelectItemLiveData.setValue(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getRemoveDialogListConfig$lambda$1(GuildRemoveGuildDialogViewModel this$0, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        this$0.curSelectItemLiveData.setValue(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getRemoveDialogListConfig$lambda$2(GuildRemoveGuildDialogViewModel this$0, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        this$0.curSelectItemLiveData.setValue(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getRemoveDialogListConfig$lambda$3(GuildRemoveGuildDialogViewModel this$0, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        this$0.curSelectItemLiveData.setValue(3);
    }

    @NotNull
    public final MutableLiveData<Integer> getCurSelectItemLiveData() {
        return this.curSelectItemLiveData;
    }

    @NotNull
    public final RemoveFromGuildData getMData() {
        RemoveFromGuildData removeFromGuildData = this.mData;
        if (removeFromGuildData != null) {
            return removeFromGuildData;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mData");
        return null;
    }

    public final int getMsgRevokeType() {
        Integer value = this.curSelectItemLiveData.getValue();
        if (value != null && value.intValue() == 0) {
            return 0;
        }
        if (value != null && value.intValue() == 1) {
            return 2;
        }
        if (value != null && value.intValue() == 2) {
            return 4;
        }
        if (value == null || value.intValue() != 3) {
            return 0;
        }
        return 5;
    }

    @NotNull
    public final Group getRemoveDialogListConfig(@NotNull String topDescription, int curSelectItemId) {
        Intrinsics.checkNotNullParameter(topDescription, "topDescription");
        return new Group(topDescription, new x(new x.b.d("\u4fdd\u7559\u6d88\u606f"), new x.c.i(getIsSelected(0, curSelectItemId), new h() { // from class: zv1.a
            @Override // com.tencent.mobileqq.widget.listitem.h
            public final void a(View view, boolean z16) {
                GuildRemoveGuildDialogViewModel.getRemoveDialogListConfig$lambda$0(GuildRemoveGuildDialogViewModel.this, view, z16);
            }
        })), new x(new x.b.d("\u5220\u96647\u5929\u5185\u7684\u6d88\u606f"), new x.c.i(getIsSelected(1, curSelectItemId), new h() { // from class: zv1.b
            @Override // com.tencent.mobileqq.widget.listitem.h
            public final void a(View view, boolean z16) {
                GuildRemoveGuildDialogViewModel.getRemoveDialogListConfig$lambda$1(GuildRemoveGuildDialogViewModel.this, view, z16);
            }
        })), new x(new x.b.d("\u5220\u966430\u5929\u5185\u7684\u6d88\u606f"), new x.c.i(getIsSelected(2, curSelectItemId), new h() { // from class: zv1.c
            @Override // com.tencent.mobileqq.widget.listitem.h
            public final void a(View view, boolean z16) {
                GuildRemoveGuildDialogViewModel.getRemoveDialogListConfig$lambda$2(GuildRemoveGuildDialogViewModel.this, view, z16);
            }
        })), new x(new x.b.d("\u5220\u9664\u5168\u90e8\u6d88\u606f"), new x.c.i(getIsSelected(3, curSelectItemId), new h() { // from class: zv1.d
            @Override // com.tencent.mobileqq.widget.listitem.h
            public final void a(View view, boolean z16) {
                GuildRemoveGuildDialogViewModel.getRemoveDialogListConfig$lambda$3(GuildRemoveGuildDialogViewModel.this, view, z16);
            }
        })));
    }

    public final void init(@Nullable Bundle bundle) {
        RemoveFromGuildData removeFromGuildData;
        this.curSelectItemLiveData.setValue(0);
        if (bundle != null) {
            removeFromGuildData = (RemoveFromGuildData) bundle.getParcelable("KEY_REMOVE_FROM_GUILD_DATA");
        } else {
            removeFromGuildData = null;
        }
        if (removeFromGuildData == null) {
            removeFromGuildData = new RemoveFromGuildData(0, "", true, false, 0, "", false);
        }
        setMData(removeFromGuildData);
    }

    public final void setMData(@NotNull RemoveFromGuildData removeFromGuildData) {
        Intrinsics.checkNotNullParameter(removeFromGuildData, "<set-?>");
        this.mData = removeFromGuildData;
    }
}
