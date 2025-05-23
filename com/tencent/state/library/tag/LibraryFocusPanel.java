package com.tencent.state.library.tag;

import android.content.Context;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.state.common.tag.BaseTagPanel;
import com.tencent.state.common.tag.DialogTagSetInfo;
import com.tencent.state.common.tag.ITagPanelListener;
import com.tencent.state.common.tag.TagCategoryInfo;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.service.VasLibraryRoomService;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.components.SquareLibraryOnFocusEvent;
import com.tencent.state.template.data.SitDownTagParams;
import com.tencent.state.template.data.User;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000  2\u00020\u0001:\u0001 BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010\rJ\b\u0010\u0012\u001a\u00020\u0005H\u0014J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0016H\u0014J\b\u0010\u0018\u001a\u00020\u0016H\u0014J\b\u0010\u0019\u001a\u00020\u0016H\u0014J\b\u0010\u001a\u001a\u00020\u001bH\u0014J\u001a\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u0016H\u0002J\b\u0010\u001f\u001a\u00020\u001bH\u0002R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006!"}, d2 = {"Lcom/tencent/state/library/tag/LibraryFocusPanel;", "Lcom/tencent/state/common/tag/BaseTagPanel;", "context", "Landroid/content/Context;", "isSingle", "", "checkConflict", "isNeighborFocused", "roomId", "", "tableId", "tagFocusListener", "Lcom/tencent/state/common/tag/ITagPanelListener;", "(Landroid/content/Context;ZZZJJLcom/tencent/state/common/tag/ITagPanelListener;)V", "getTagFocusListener", "()Lcom/tencent/state/common/tag/ITagPanelListener;", "setTagFocusListener", "(Lcom/tencent/state/common/tag/ITagPanelListener;)V", "canShowDeskMateTagContainer", "getDialogTagSetInfo", "Lcom/tencent/state/common/tag/DialogTagSetInfo;", "getOperatorStringId", "", "getOwnerTagTitle", "getSceneType", "getSyncTitle", "onOperatorClick", "", "reportFocus", "isSuccess", "errorCode", "startFocus", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public class LibraryFocusPanel extends BaseTagPanel {
    private static final String TAG = "LibraryFocusPanel";
    private final boolean isNeighborFocused;
    private final long roomId;
    private final long tableId;
    private ITagPanelListener tagFocusListener;

    public /* synthetic */ LibraryFocusPanel(Context context, boolean z16, boolean z17, boolean z18, long j3, long j16, ITagPanelListener iTagPanelListener, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, z16, z17, z18, j3, j16, (i3 & 64) != 0 ? null : iTagPanelListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void reportFocus(boolean isSuccess, int errorCode) {
        String str;
        Map<String, Object> mutableMapOf;
        ArrayList<TagCategoryInfo> ownerCategoryList = getOwnerCategoryList();
        TagCategoryInfo tagCategoryInfo = null;
        if (ownerCategoryList != null) {
            Iterator<T> it = ownerCategoryList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (Intrinsics.areEqual(((TagCategoryInfo) next).getCategoryName(), getCurrentOwnerCategory())) {
                    tagCategoryInfo = next;
                    break;
                }
            }
            tagCategoryInfo = tagCategoryInfo;
        }
        Pair[] pairArr = new Pair[7];
        pairArr[0] = TuplesKt.to(SquareReportConst.Key.KEY_FOCUS_WRITE_TYPE, Integer.valueOf(!getIsSingle() ? 1 : 0));
        if (tagCategoryInfo == null || (str = tagCategoryInfo.getCategory()) == null) {
            str = "";
        }
        pairArr[1] = TuplesKt.to(SquareReportConst.Key.KEY_FIND_FOCUS_ID, str);
        String currentDeskMateTagId = getCurrentDeskMateTagId();
        if (currentDeskMateTagId == null) {
            currentDeskMateTagId = "";
        }
        pairArr[2] = TuplesKt.to(SquareReportConst.Key.KEY_FIND_DESKMATE_ID, currentDeskMateTagId);
        pairArr[3] = TuplesKt.to(SquareReportConst.Key.KEY_IS_TICK, Integer.valueOf(getIsShow() ? 1 : 0));
        String currentOwnerTagId = getCurrentOwnerTagId();
        pairArr[4] = TuplesKt.to(SquareReportConst.Key.KEY_IS_FOCUS_TEXT, currentOwnerTagId != null ? currentOwnerTagId : "");
        pairArr[5] = TuplesKt.to("zplan_action_result", Integer.valueOf(isSuccess ? 1 : 0));
        pairArr[6] = TuplesKt.to("zplan_event_source_parameters", Integer.valueOf(getSceneType()));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        if (!isSuccess) {
            mutableMapOf.put("zplan_action_fail_reason", Integer.valueOf(errorCode));
        }
        getReporter().reportEvent(SquareReportConst.CustomEventId.EVENT_ID_FOCUS_BEGIN, mutableMapOf);
    }

    private final void startFocus() {
        String str;
        if (canShowDeskMateTagContainer()) {
            str = getCurrentDeskMateTagId();
        } else {
            str = "";
        }
        final SitDownTagParams sitDownTagParams = new SitDownTagParams(this.roomId, this.tableId, getCurrentOwnerTagId(), str, getIsShow(), null);
        VasLibraryRoomService.INSTANCE.sitDown(sitDownTagParams, new ResultCallback<User>() { // from class: com.tencent.state.library.tag.LibraryFocusPanel$startFocus$1
            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str2) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str2);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int error, String message, String prompt) {
                boolean z16 = true;
                boolean z17 = error == -24022;
                if (!z17) {
                    if (prompt != null && prompt.length() != 0) {
                        z16 = false;
                    }
                    if (!z16) {
                        ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
                        Context context = LibraryFocusPanel.this.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        ICommonUtils.DefaultImpls.showToast$default(squareCommon, context, prompt, 0, 4, (Object) null);
                    }
                }
                ITagPanelListener tagFocusListener = LibraryFocusPanel.this.getTagFocusListener();
                if (tagFocusListener != null) {
                    tagFocusListener.onFocusFailed(z17, sitDownTagParams);
                }
                LibraryFocusPanel.this.reportFocus(false, error);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultSuccess(User result) {
                if (result != null) {
                    ITagPanelListener tagFocusListener = LibraryFocusPanel.this.getTagFocusListener();
                    if (tagFocusListener != null) {
                        tagFocusListener.onFocusSuccess(result);
                    }
                    SimpleEventBus.getInstance().dispatchEvent(new SquareLibraryOnFocusEvent());
                } else {
                    ITagPanelListener tagFocusListener2 = LibraryFocusPanel.this.getTagFocusListener();
                    if (tagFocusListener2 != null) {
                        tagFocusListener2.onFocusFailed(false, sitDownTagParams);
                    }
                }
                LibraryFocusPanel.reportFocus$default(LibraryFocusPanel.this, true, 0, 2, null);
                VasLibraryTagManager.INSTANCE.getTagInfosFromServer();
            }
        });
    }

    @Override // com.tencent.state.common.tag.BaseTagPanel
    protected boolean canShowDeskMateTagContainer() {
        return (getIsSingle() || this.isNeighborFocused) ? false : true;
    }

    @Override // com.tencent.state.common.tag.BaseTagPanel
    protected DialogTagSetInfo getDialogTagSetInfo() {
        DialogTagSetInfo tagInfo = VasLibraryTagManager.INSTANCE.getTagInfo();
        return tagInfo != null ? tagInfo : LibraryTagInfoKt.getDefaultDialogTagSetInfo();
    }

    @Override // com.tencent.state.common.tag.BaseTagPanel
    protected int getOperatorStringId() {
        return R.string.xh8;
    }

    @Override // com.tencent.state.common.tag.BaseTagPanel
    protected int getOwnerTagTitle() {
        return R.string.xf5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.common.tag.BaseTagPanel
    public int getSceneType() {
        return 1;
    }

    @Override // com.tencent.state.common.tag.BaseTagPanel
    protected int getSyncTitle() {
        return R.string.xgi;
    }

    public final ITagPanelListener getTagFocusListener() {
        return this.tagFocusListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.common.tag.BaseTagPanel
    public void onOperatorClick() {
        startFocus();
    }

    public final void setTagFocusListener(ITagPanelListener iTagPanelListener) {
        this.tagFocusListener = iTagPanelListener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LibraryFocusPanel(Context context, boolean z16, boolean z17, boolean z18, long j3, long j16, ITagPanelListener iTagPanelListener) {
        super(context, z16, z17);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isNeighborFocused = z18;
        this.roomId = j3;
        this.tableId = j16;
        this.tagFocusListener = iTagPanelListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void reportFocus$default(LibraryFocusPanel libraryFocusPanel, boolean z16, int i3, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 2) != 0) {
                i3 = -1;
            }
            libraryFocusPanel.reportFocus(z16, i3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportFocus");
    }
}
