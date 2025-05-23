package com.tencent.mobileqq.friend.group;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.contacts.base.c;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.friend.group.c;
import com.tencent.mobileqq.friend.permissionmanager.FriendPermissionSettingFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.u;
import com.tencent.qqnt.ntrelation.api.IFriendsTABService;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/friend/group/c;", "", "a", "qqfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018JF\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eR\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/friend/group/c$a;", "", "Landroid/view/View;", "view", "", "canChildAction", "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/b;", "Lkotlin/collections/ArrayList;", "ntCategoryInfoList", "Lcom/tencent/mobileqq/friend/group/GroupListAdapter;", "groupListAdapter", "Lcom/tencent/mobileqq/app/QQAppInterface;", "appInterface", "b", "", "NT_SPECAIL_GROUP_ID", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.friend.group.c$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(int i3, Context context, QQAppInterface appInterface, ActionSheet actionSheet, View view, int i16) {
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(appInterface, "$appInterface");
            Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
            int id5 = view.getId();
            if (id5 == 1) {
                Intent intent = new Intent();
                intent.putExtra("groupId", i3);
                QPublicFragmentActivity.start(context, intent, FriendPermissionSettingFragment.class);
                ReportController.o(appInterface, "dc00898", "", "", "0X800C115", "0X800C115", 0, 0, "", "", "", "");
            } else if (id5 == 2) {
                GroupManagerActivity.startGroupManager((Activity) context);
                ReportController.o(appInterface, "dc00898", "", "", "0X800C11A", "0X800C11A", 0, 0, "", "", "", "");
            }
            actionSheet.dismiss();
        }

        public final boolean b(View view, boolean canChildAction, final Context context, ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> ntCategoryInfoList, GroupListAdapter groupListAdapter, final QQAppInterface appInterface) {
            Object tag;
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(ntCategoryInfoList, "ntCategoryInfoList");
            Intrinsics.checkNotNullParameter(groupListAdapter, "groupListAdapter");
            Intrinsics.checkNotNullParameter(appInterface, "appInterface");
            if (u.a().b() || !canChildAction || (tag = view.getTag()) == null) {
                return false;
            }
            if (tag instanceof com.tencent.mobileqq.troop.adapter.contact.a) {
                boolean isNtDataService = ((IFriendsTABService) QRoute.api(IFriendsTABService.class)).isNtDataService();
                com.tencent.mobileqq.troop.adapter.contact.a aVar = (com.tencent.mobileqq.troop.adapter.contact.a) tag;
                int i3 = aVar.f293797a;
                final int a16 = ntCategoryInfoList.get(i3).a();
                if ((isNtDataService && a16 == 9999) || (!isNtDataService && a16 == 1004)) {
                    return false;
                }
                Dialog createDialog = ActionSheetHelper.createDialog(context, null);
                Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
                final ActionSheet actionSheet = (ActionSheet) createDialog;
                CharSequence text = aVar.f293800d.getText();
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = context.getString(R.string.f225416lk);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(string\u2026ission_actionsheet_title)");
                String format = String.format(string, Arrays.copyOf(new Object[]{text}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                actionSheet.setMainTitle(format);
                if (groupListAdapter.getChildrenCount(i3) > 0) {
                    actionSheet.addButton(R.string.f225366lf, 1, 1);
                }
                actionSheet.addButton(R.string.f1384609m, 1, 2);
                actionSheet.addCancelButton(R.string.cancel);
                actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.friend.group.b
                    @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                    public final void onClick(View view2, int i16) {
                        c.Companion.c(a16, context, appInterface, actionSheet, view2, i16);
                    }
                });
                actionSheet.show();
                ReportController.o(appInterface, "dc00898", "", "", "0X800C110", "0X800C110", 0, 0, "", "", "", "");
            } else {
                boolean z16 = tag instanceof c.C7154c;
            }
            return true;
        }

        Companion() {
        }
    }
}
