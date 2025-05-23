package com.tencent.state.square.detail;

import android.os.Bundle;
import com.tencent.state.square.guide.NoviceGuideRecordForReport;
import com.tencent.state.utils.SquareSwitchUtils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 .2\u00020\u0001:\u0001.B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010(\u001a\u00020\u00002\b\u0010)\u001a\u0004\u0018\u00010*H\u0017J\u000e\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000eR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\u001a\u0010\"\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\u001a\u0010%\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\b\u00a8\u0006/"}, d2 = {"Lcom/tencent/state/square/detail/DetailMeFragmentConfig;", "Lcom/tencent/state/square/detail/BaseDetailFragmentConfig;", "()V", "autoEnterEditState", "", "getAutoEnterEditState", "()Z", "setAutoEnterEditState", "(Z)V", "curActionId", "", "getCurActionId", "()Ljava/lang/Integer;", "setCurActionId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "curRichStatusId", "getCurRichStatusId", "setCurRichStatusId", "curStatusId", "getCurStatusId", "setCurStatusId", "multiMotionId", "getMultiMotionId", "setMultiMotionId", "noviceGuideRecord", "Lcom/tencent/state/square/guide/NoviceGuideRecordForReport;", "getNoviceGuideRecord", "()Lcom/tencent/state/square/guide/NoviceGuideRecordForReport;", "setNoviceGuideRecord", "(Lcom/tencent/state/square/guide/NoviceGuideRecordForReport;)V", "openBubblePanel", "getOpenBubblePanel", "setOpenBubblePanel", "openInteractionRecordPanel", "getOpenInteractionRecordPanel", "setOpenInteractionRecordPanel", "openSeedPanel", "getOpenSeedPanel", "setOpenSeedPanel", "convertFromScheme", "bundle", "Landroid/os/Bundle;", "schemeOnceKey", "", "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class DetailMeFragmentConfig extends BaseDetailFragmentConfig {
    public static final String CURRENT_ACTION_ID = "actionId";
    public static final String CURRENT_RICH_ID = "richStatusId";
    public static final String CURRENT_STATUS_ID = "statusId";
    public static final String NEED_OPEN_PANEL = "needOpenStatusPanel";
    public static final String OPEN_BUBBLE_PANEL = "open_bubble_setting_panel";
    public static final String OPEN_FLOWER_PANEL = "open_flower_panel";
    public static final String OPEN_INTERACTION_RECORD_PANEL = "open_interaction_record_panel";
    private boolean autoEnterEditState;
    private Integer curActionId;
    private Integer curRichStatusId;
    private Integer curStatusId;
    private Integer multiMotionId;
    private NoviceGuideRecordForReport noviceGuideRecord;
    private boolean openBubblePanel;
    private boolean openInteractionRecordPanel;
    private boolean openSeedPanel;

    public final boolean getAutoEnterEditState() {
        return this.autoEnterEditState;
    }

    public final Integer getCurActionId() {
        return this.curActionId;
    }

    public final Integer getCurRichStatusId() {
        return this.curRichStatusId;
    }

    public final Integer getCurStatusId() {
        return this.curStatusId;
    }

    public final Integer getMultiMotionId() {
        return this.multiMotionId;
    }

    public final NoviceGuideRecordForReport getNoviceGuideRecord() {
        return this.noviceGuideRecord;
    }

    public final boolean getOpenBubblePanel() {
        return this.openBubblePanel;
    }

    public final boolean getOpenInteractionRecordPanel() {
        return this.openInteractionRecordPanel;
    }

    public final boolean getOpenSeedPanel() {
        return this.openSeedPanel;
    }

    @Override // com.tencent.state.square.detail.BaseDetailFragmentConfig
    public Set<String> schemeOnceKey() {
        Set<String> schemeOnceKey = super.schemeOnceKey();
        schemeOnceKey.add(OPEN_INTERACTION_RECORD_PANEL);
        return schemeOnceKey;
    }

    public final void setAutoEnterEditState(boolean z16) {
        this.autoEnterEditState = z16;
    }

    public final void setCurActionId(Integer num) {
        this.curActionId = num;
    }

    public final void setCurRichStatusId(Integer num) {
        this.curRichStatusId = num;
    }

    public final void setCurStatusId(Integer num) {
        this.curStatusId = num;
    }

    public final void setMultiMotionId(Integer num) {
        this.multiMotionId = num;
    }

    public final void setNoviceGuideRecord(NoviceGuideRecordForReport noviceGuideRecordForReport) {
        this.noviceGuideRecord = noviceGuideRecordForReport;
    }

    public final void setOpenBubblePanel(boolean z16) {
        this.openBubblePanel = z16;
    }

    public final void setOpenInteractionRecordPanel(boolean z16) {
        this.openInteractionRecordPanel = z16;
    }

    public final void setOpenSeedPanel(boolean z16) {
        this.openSeedPanel = z16;
    }

    @Override // com.tencent.state.square.detail.BaseDetailFragmentConfig
    public DetailMeFragmentConfig convertFromScheme(Bundle bundle) {
        if (bundle != null && bundle.containsKey(NEED_OPEN_PANEL)) {
            this.autoEnterEditState = Intrinsics.areEqual(bundle.getString(NEED_OPEN_PANEL), "1");
        }
        if (bundle != null && bundle.containsKey(CURRENT_STATUS_ID)) {
            String string = bundle.getString(CURRENT_STATUS_ID);
            this.curStatusId = string != null ? StringsKt__StringNumberConversionsKt.toIntOrNull(string) : null;
        }
        if (bundle != null && bundle.containsKey(CURRENT_RICH_ID)) {
            String string2 = bundle.getString(CURRENT_RICH_ID);
            this.curRichStatusId = string2 != null ? StringsKt__StringNumberConversionsKt.toIntOrNull(string2) : null;
        }
        if (bundle != null && bundle.containsKey("actionId")) {
            String string3 = bundle.getString("actionId");
            this.curActionId = string3 != null ? StringsKt__StringNumberConversionsKt.toIntOrNull(string3) : null;
        }
        if (bundle != null && bundle.containsKey(OPEN_INTERACTION_RECORD_PANEL)) {
            this.openInteractionRecordPanel = Intrinsics.areEqual(bundle.getString(OPEN_INTERACTION_RECORD_PANEL), "1");
            if (SquareSwitchUtils.INSTANCE.enableFilamentDetail()) {
                this.openInteractionRecordPanel = false;
            }
        }
        if (bundle != null && bundle.containsKey(BaseDetailFragmentConfig.LIKE_TYPE)) {
            String string4 = bundle.getString(BaseDetailFragmentConfig.LIKE_TYPE);
            setPlayPagLikeType(string4 != null ? StringsKt__StringNumberConversionsKt.toIntOrNull(string4) : null);
        }
        if (bundle != null && bundle.containsKey(OPEN_FLOWER_PANEL)) {
            this.openSeedPanel = Intrinsics.areEqual(bundle.getString(OPEN_FLOWER_PANEL), "1");
        }
        if (bundle != null && bundle.containsKey(OPEN_BUBBLE_PANEL)) {
            this.openBubblePanel = Intrinsics.areEqual(bundle.getString(OPEN_BUBBLE_PANEL), "1");
        }
        if (bundle != null && bundle.containsKey(BaseDetailFragmentConfig.ENTER_WITH_SCALE)) {
            setEnterWithScaleAnim(Intrinsics.areEqual(bundle.getString(BaseDetailFragmentConfig.ENTER_WITH_SCALE), "1"));
        }
        return this;
    }
}
