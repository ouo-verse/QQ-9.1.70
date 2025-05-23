package com.tencent.mobileqq.guild.rolegroup.levelrole;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.rolegroup.levelrole.a;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001<B'\u0012\u0006\u00108\u001a\u000207\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0015\u001a\u00020\f\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u001a\u0010\u000e\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010$R\u0014\u0010-\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010(R\u0014\u0010/\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010$R\u0014\u00101\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010$R\u0014\u00103\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010 R\u0016\u00106\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/levelrole/f;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "", "t", "", "u", "Lcom/tencent/mobileqq/guild/rolegroup/levelrole/LevelRoleUIData;", "itemData", "r", "Landroid/widget/CompoundButton;", "buttonView", "", "isChecked", "onCheckedChanged", "Lcom/tencent/mobileqq/guild/rolegroup/levelrole/PageLayoutType;", "E", "Lcom/tencent/mobileqq/guild/rolegroup/levelrole/PageLayoutType;", "pageLayoutType", UserInfo.SEX_FEMALE, "Z", "isNewFeedSquareGuild", "Lcom/tencent/mobileqq/guild/rolegroup/levelrole/a$b;", "G", "Lcom/tencent/mobileqq/guild/rolegroup/levelrole/a$b;", "callback", "Landroid/widget/CheckBox;", "H", "Landroid/widget/CheckBox;", "mCheckBox", "Landroid/widget/ImageView;", "I", "Landroid/widget/ImageView;", "mRoleIcon", "Landroid/widget/TextView;", "J", "Landroid/widget/TextView;", "mRoleLVName", "Landroid/view/View;", "K", "Landroid/view/View;", "mRoleNameDivide", "L", "mRoleName", "M", "mRoleDescContainer", "N", "mRoleDesc", "P", "mRoleMemberCount", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mRoleDelete", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/guild/rolegroup/levelrole/LevelRoleUIData;", "mUIData", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "(Landroid/view/ViewGroup;Lcom/tencent/mobileqq/guild/rolegroup/levelrole/PageLayoutType;ZLcom/tencent/mobileqq/guild/rolegroup/levelrole/a$b;)V", ExifInterface.LATITUDE_SOUTH, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class f extends RecyclerView.ViewHolder implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final PageLayoutType pageLayoutType;

    /* renamed from: F, reason: from kotlin metadata */
    private final boolean isNewFeedSquareGuild;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final a.b callback;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final CheckBox mCheckBox;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final ImageView mRoleIcon;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final TextView mRoleLVName;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final View mRoleNameDivide;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final TextView mRoleName;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final View mRoleDescContainer;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final TextView mRoleDesc;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final TextView mRoleMemberCount;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final ImageView mRoleDelete;

    /* renamed from: R, reason: from kotlin metadata */
    private LevelRoleUIData mUIData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/levelrole/f$a;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "kotlin.jvm.PlatformType", "b", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.rolegroup.levelrole.f$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final View b(ViewGroup parent) {
            return LayoutInflater.from(parent.getContext()).inflate(R.layout.evw, parent, false);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f232635a;

        static {
            int[] iArr = new int[PageLayoutType.values().length];
            try {
                iArr[PageLayoutType.MANAGE_AND_ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PageLayoutType.MANAGE_AND_DELETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PageLayoutType.VIEW_LEVEL_ROLES_ENTRANCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PageLayoutType.BIND_CHANNEL_VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PageLayoutType.BIND_CHANNEL_SPEAKABLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f232635a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull ViewGroup parent, @NotNull PageLayoutType pageLayoutType, boolean z16, @NotNull a.b callback) {
        super(INSTANCE.b(parent));
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(pageLayoutType, "pageLayoutType");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.pageLayoutType = pageLayoutType;
        this.isNewFeedSquareGuild = z16;
        this.callback = callback;
        View findViewById = this.itemView.findViewById(R.id.wlh);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026uild_level_role_checkbox)");
        CheckBox checkBox = (CheckBox) findViewById;
        this.mCheckBox = checkBox;
        View findViewById2 = this.itemView.findViewById(R.id.wln);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.guild_level_role_icon)");
        this.mRoleIcon = (ImageView) findViewById2;
        View findViewById3 = this.itemView.findViewById(R.id.wlq);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.\u2026guild_level_role_lv_name)");
        this.mRoleLVName = (TextView) findViewById3;
        View findViewById4 = this.itemView.findViewById(R.id.wlt);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.\u2026d_level_role_name_divide)");
        this.mRoleNameDivide = findViewById4;
        View findViewById5 = this.itemView.findViewById(R.id.wls);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.guild_level_role_name)");
        this.mRoleName = (TextView) findViewById5;
        View findViewById6 = this.itemView.findViewById(R.id.wlm);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.\u2026evel_role_desc_container)");
        this.mRoleDescContainer = findViewById6;
        View findViewById7 = this.itemView.findViewById(R.id.wll);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.id.guild_level_role_desc)");
        this.mRoleDesc = (TextView) findViewById7;
        View findViewById8 = this.itemView.findViewById(R.id.wlr);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "itemView.findViewById(R.\u2026_level_role_member_count)");
        this.mRoleMemberCount = (TextView) findViewById8;
        View findViewById9 = this.itemView.findViewById(R.id.wlk);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "itemView.findViewById(R.\u2026.guild_level_role_delete)");
        this.mRoleDelete = (ImageView) findViewById9;
        int i3 = b.f232635a[pageLayoutType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.rolegroup.levelrole.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        f.p(f.this, view);
                    }
                });
                return;
            } else {
                this.itemView.setOnClickListener(null);
                return;
            }
        }
        checkBox.setOnCheckedChangeListener(this);
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.rolegroup.levelrole.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.o(f.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(f this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mCheckBox.setChecked(!r1.isChecked());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(f this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a.b bVar = this$0.callback;
        LevelRoleUIData levelRoleUIData = this$0.mUIData;
        if (levelRoleUIData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUIData");
            levelRoleUIData = null;
        }
        bVar.a(view, levelRoleUIData);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(f this$0, LevelRoleUIData itemData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(itemData, "$itemData");
        this$0.callback.d(view, itemData);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final String t() {
        if (this.isNewFeedSquareGuild) {
            return "\u5b50\u9891\u9053/\u7248\u5757";
        }
        return "\u5b50\u9891\u9053";
    }

    private final void u() {
        this.mRoleDescContainer.setVisibility(0);
        this.mCheckBox.setVisibility(8);
        this.mRoleDelete.setVisibility(8);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(@Nullable CompoundButton buttonView, boolean isChecked) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(buttonView, isChecked);
        Logger.a d16 = Logger.f235387a.d();
        LevelRoleUIData levelRoleUIData = this.mUIData;
        LevelRoleUIData levelRoleUIData2 = null;
        if (levelRoleUIData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUIData");
            levelRoleUIData = null;
        }
        d16.d("Guild.rg.LevelRole.ListViewHolder", 1, "onCheckBoxChange  isChecked:" + isChecked + " itemData:" + levelRoleUIData);
        a.b bVar = this.callback;
        LevelRoleUIData levelRoleUIData3 = this.mUIData;
        if (levelRoleUIData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUIData");
        } else {
            levelRoleUIData2 = levelRoleUIData3;
        }
        bVar.c(buttonView, levelRoleUIData2, isChecked);
        EventCollector.getInstance().onCompoundButtonChecked(buttonView, isChecked);
    }

    public final void r(@NotNull final LevelRoleUIData itemData) {
        boolean z16;
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        this.mUIData = itemData;
        this.mRoleLVName.setText(itemData.getRoleLVName());
        v.l(itemData.getRoleIcon(), this.mRoleIcon, null, 4, null);
        if (itemData.getRoleName().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.mRoleNameDivide.setVisibility(8);
            this.mRoleName.setText("");
        } else {
            this.mRoleNameDivide.setVisibility(0);
            this.mRoleName.setText(itemData.getRoleName());
        }
        int i3 = b.f232635a[this.pageLayoutType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            this.mRoleDesc.setVisibility(8);
                            this.mRoleMemberCount.setText(itemData.getChannelNumCanSpeak() + "\u4e2a" + t());
                            u();
                            return;
                        }
                        return;
                    }
                    this.mRoleDesc.setVisibility(8);
                    this.mRoleMemberCount.setText(itemData.getChannelNumCanSee() + "\u4e2a" + t());
                    u();
                    return;
                }
                this.mRoleDesc.setText(itemData.getRoleDesc());
                this.mRoleMemberCount.setText(itemData.getRoleMemberCount() + "\u4eba");
                u();
                return;
            }
            this.mCheckBox.setVisibility(8);
            this.mRoleDescContainer.setVisibility(8);
            this.mRoleDelete.setVisibility(0);
            this.mRoleDelete.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.rolegroup.levelrole.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    f.s(f.this, itemData, view);
                }
            });
            return;
        }
        this.mCheckBox.setVisibility(0);
        this.mRoleDescContainer.setVisibility(8);
        this.mRoleDelete.setVisibility(8);
        this.mCheckBox.setChecked(this.callback.b(itemData.getRoleId()));
    }
}
