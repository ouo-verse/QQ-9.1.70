package com.tencent.mobileqq.guild.base;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R(\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/base/GuildTransBottomSheetDialogFragment;", "Lcom/tencent/mobileqq/guild/base/GuildBaseTransFragment;", "Lcom/tencent/mobileqq/guild/base/GuildBaseBottomSheetFragment;", "rh", "Landroid/content/Context;", "context", "", "onAttach", "<set-?>", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/base/GuildBaseBottomSheetFragment;", "getBottomSheetDialogFragment", "()Lcom/tencent/mobileqq/guild/base/GuildBaseBottomSheetFragment;", "bottomSheetDialogFragment", "<init>", "()V", "D", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildTransBottomSheetDialogFragment extends GuildBaseTransFragment {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private GuildBaseBottomSheetFragment bottomSheetDialogFragment;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tH\u0007R\u0014\u0010\r\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/base/GuildTransBottomSheetDialogFragment$a;", "", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/guild/base/GuildBaseBottomSheetFragment;", "cls", "", "tag", "", "a", "EXTRA_BOTTOM_SHEET_DIALOG_CLASS_NAME", "Ljava/lang/String;", "EXTRA_BOTTOM_SHEET_TAG", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.base.GuildTransBottomSheetDialogFragment$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull Context context, @NotNull Intent intent, @NotNull Class<? extends GuildBaseBottomSheetFragment> cls, @NotNull String tag) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            Intrinsics.checkNotNullParameter(cls, "cls");
            Intrinsics.checkNotNullParameter(tag, "tag");
            intent.putExtra("EXTRA_BOTTOM_SHEET_DIALOG_CLASS_NAME", cls.getName());
            intent.putExtra("EXTRA_BOTTOM_SHEET_TAG", tag);
            intent.putExtra("public_fragment_window_feature", 1);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            QPublicTransFragmentActivity.start(context, intent, GuildTransBottomSheetDialogFragment.class);
        }

        Companion() {
        }
    }

    private final GuildBaseBottomSheetFragment rh() {
        String str;
        Bundle bundle;
        Intent intent;
        Intent intent2;
        FragmentActivity activity = getActivity();
        if (activity != null && (intent2 = activity.getIntent()) != null) {
            str = intent2.getStringExtra("EXTRA_BOTTOM_SHEET_DIALOG_CLASS_NAME");
        } else {
            str = null;
        }
        if (str == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("create fragment error cls is null");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildTransBottomSheetDialogFragment", 1, (String) it.next(), null);
            }
            return null;
        }
        try {
            Object newInstance = Class.forName(str).newInstance();
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.mobileqq.guild.base.GuildBaseBottomSheetFragment");
            GuildBaseBottomSheetFragment guildBaseBottomSheetFragment = (GuildBaseBottomSheetFragment) newInstance;
            FragmentActivity activity2 = getActivity();
            if (activity2 != null && (intent = activity2.getIntent()) != null) {
                bundle = intent.getExtras();
            } else {
                bundle = null;
            }
            guildBaseBottomSheetFragment.setArguments(bundle);
            return guildBaseBottomSheetFragment;
        } catch (Exception e16) {
            Logger logger2 = Logger.f235387a;
            Logger.b bVar2 = new Logger.b();
            String str2 = "create fragment error e=" + e16;
            if (str2 instanceof String) {
                bVar2.a().add(str2);
            }
            Iterator<T> it5 = bVar2.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e("GuildTransBottomSheetDialogFragment", 1, (String) it5.next(), null);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sh(GuildTransBottomSheetDialogFragment this$0, FragmentActivity fragmentActivity, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildTransBottomSheetDialogFragment", 2, "dismiss");
        }
        this$0.finish();
        fragmentActivity.overridePendingTransition(R.anim.l_, R.anim.l_);
    }

    @JvmStatic
    public static final void th(@NotNull Context context, @NotNull Intent intent, @NotNull Class<? extends GuildBaseBottomSheetFragment> cls, @NotNull String str) {
        INSTANCE.a(context, intent, cls, str);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        this.bottomSheetDialogFragment = rh();
        final FragmentActivity activity = getActivity();
        if (activity != null && this.bottomSheetDialogFragment != null) {
            FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            GuildBaseBottomSheetFragment guildBaseBottomSheetFragment = this.bottomSheetDialogFragment;
            Intrinsics.checkNotNull(guildBaseBottomSheetFragment);
            Intent intent = activity.getIntent();
            if (intent == null || (str = intent.getStringExtra("EXTRA_BOTTOM_SHEET_TAG")) == null) {
                str = PM.BASE;
            }
            com.tencent.mobileqq.guild.base.extension.d.a(guildBaseBottomSheetFragment, supportFragmentManager, str);
            GuildBaseBottomSheetFragment guildBaseBottomSheetFragment2 = this.bottomSheetDialogFragment;
            Intrinsics.checkNotNull(guildBaseBottomSheetFragment2);
            guildBaseBottomSheetFragment2.ph(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.guild.base.d
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    GuildTransBottomSheetDialogFragment.sh(GuildTransBottomSheetDialogFragment.this, activity, dialogInterface);
                }
            });
            return;
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        bVar.a().add("activity is null");
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("GuildTransBottomSheetDialogFragment", 1, (String) it.next(), null);
        }
        finish();
    }
}
