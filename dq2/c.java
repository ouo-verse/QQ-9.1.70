package dq2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.ViewModel;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.selectfriend.model.FSLayoutData;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J3\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u0012\u0010\u0013Jw\u0010!\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2&\u0010\u001c\u001a\"\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0018j\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00062\b\u0010 \u001a\u0004\u0018\u00010\u001f\u00a2\u0006\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Ldq2/c;", "Landroidx/lifecycle/ViewModel;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "P1", "Landroid/os/Bundle;", "bundle", "Lzp2/b;", "L1", "", "style", "", "isShowGuildEntrance", "recentHeadData", "", "N1", "(Landroid/content/Context;Ljava/lang/Integer;Ljava/lang/Boolean;Lzp2/b;)V", "M1", "(Landroid/content/Context;Ljava/lang/Integer;Lzp2/b;)V", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "intent", "uinType", "Ljava/util/LinkedHashMap;", "", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "Lkotlin/collections/LinkedHashMap;", "forwardTargetMap", ForwardRecentActivity.KEY_SEARCH_SOURCE, WadlProxyConsts.EXTRA_DATA, "Lcom/tencent/mobileqq/selectfriend/model/FSLayoutData;", "fsLayoutData", "O1", "(Landroid/app/Activity;Landroid/content/Intent;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/LinkedHashMap;Ljava/lang/Integer;Landroid/os/Bundle;Lcom/tencent/mobileqq/selectfriend/model/FSLayoutData;)V", "<init>", "()V", "i", "a", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c extends ViewModel {
    public final zp2.b L1(Context context, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        zp2.b bVar = new zp2.b();
        Integer valueOf = bundle != null ? Integer.valueOf(bundle.getInt("choose_friend_businessType")) : null;
        Integer valueOf2 = bundle != null ? Integer.valueOf(bundle.getInt("choose_friend_businessSubType")) : null;
        Integer valueOf3 = bundle != null ? Integer.valueOf(bundle.getInt("key_chat_list_head_style")) : null;
        if (valueOf != null && valueOf.intValue() == 1 && valueOf2 != null && valueOf2.intValue() > 0 && valueOf2.intValue() < 3) {
            String string = context.getResources().getString(R.string.bcb);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026.forward_tab_title_topay)");
            bVar.e(string);
        } else if (valueOf3 != null && valueOf3.intValue() == 0) {
            String string2 = context.getResources().getString(R.string.f169701x42);
            Intrinsics.checkNotNullExpressionValue(string2, "context.resources.getStr\u2026orward_tab_title_recent))");
            bVar.e(string2);
            bVar.g(8);
        } else {
            String string3 = context.getResources().getString(R.string.x48);
            Intrinsics.checkNotNullExpressionValue(string3, "context.resources.getStr\u2026lect_qb_recent_chat_head)");
            bVar.e(string3);
            String string4 = context.getResources().getString(R.string.f169702x43);
            Intrinsics.checkNotNullExpressionValue(string4, "context.resources.getStr\u2026g.select_create_new_chat)");
            bVar.f(string4);
            bVar.g(0);
            bVar.h(0);
        }
        return bVar;
    }

    public final void M1(Context context, Integer style, zp2.b recentHeadData) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (style != null && style.intValue() == 0) {
            if (recentHeadData != null) {
                String string = context.getResources().getString(R.string.f170800zp0);
                Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026R.string.create_new_chat)");
                recentHeadData.f(string);
            }
            if (recentHeadData != null) {
                recentHeadData.h(0);
            }
            if (recentHeadData == null) {
                return;
            }
            recentHeadData.g(0);
        }
    }

    public final void N1(Context context, Integer style, Boolean isShowGuildEntrance, zp2.b recentHeadData) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (style != null && style.intValue() == 0) {
            return;
        }
        if (!Intrinsics.areEqual(isShowGuildEntrance, Boolean.TRUE)) {
            if (recentHeadData == null) {
                return;
            }
            String string = context.getResources().getString(R.string.f170745zm3);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026rom_contacts_guild_title)");
            recentHeadData.f(string);
            return;
        }
        if (recentHeadData != null) {
            String string2 = context.getResources().getString(R.string.f170744zm2);
            Intrinsics.checkNotNullExpressionValue(string2, "context.resources.getStr\u2026oose_from_contacts_guild)");
            recentHeadData.f(string2);
        }
        if (recentHeadData != null) {
            recentHeadData.h(0);
        }
        if (recentHeadData == null) {
            return;
        }
        recentHeadData.g(0);
    }

    public final void O1(Activity activity, Intent intent, Integer uinType, Boolean isShowGuildEntrance, LinkedHashMap<String, ResultRecord> forwardTargetMap, Integer searchSource, Bundle extraData, FSLayoutData fsLayoutData) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(intent, "intent");
        intent.setClass(activity, ForwardFriendListActivity.class);
        intent.putExtra("extra_choose_friend", 8);
        boolean z16 = false;
        if ((fsLayoutData != null ? Integer.valueOf(fsLayoutData.c()) : null) != null) {
            if (fsLayoutData != null && fsLayoutData.c() == 0) {
                z16 = true;
            }
        }
        intent.putExtra("only_single_selection", z16);
        intent.putExtra(AppConstants.Key.FORWARD_SOURCE_UIN_TYPE, uinType);
        intent.putExtra("key_forward_is_show_troop", true);
        intent.putExtra("key_forward_is_show_guild", isShowGuildEntrance);
        intent.putParcelableArrayListExtra("selected_target_list", new ArrayList<>(forwardTargetMap != null ? forwardTargetMap.values() : null));
        intent.putExtra(ForwardRecentActivity.KEY_SEARCH_SOURCE, searchSource);
        activity.startActivityForResult(intent, 20000);
    }

    public final Intent P1(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.putExtra("param_type", com.tencent.mobileqq.selectfriend.constant.a.INSTANCE.c());
        intent.putExtra(ISelectMemberActivityConstants.PARAM_SUBTYPE, 0);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_DONE_BUTTON_WORDING, context.getString(R.string.f169704x45));
        intent.putExtra(ISelectMemberActivityConstants.PARAM_DONE_BUTTON_HIGHLIGHT_WORDING, context.getString(R.string.x46));
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MIN, 1);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, 99);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_DONOT_NEED_CONTACTS, true);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_ENTRANCE, 12);
        return intent;
    }
}
