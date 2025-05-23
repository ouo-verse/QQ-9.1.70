package com.tencent.state.library.tag;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.state.common.tag.CommonTagInfo;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.service.VasLibraryRoomService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\b\u0010\u0013\u001a\u00020\u0011H\u0014J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0015H\u0014J\b\u0010\u0019\u001a\u00020\u0015H\u0014R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/state/library/tag/LibraryEditDeskMateTagPanel;", "Lcom/tencent/state/library/tag/LibraryFocusPanel;", "context", "Landroid/content/Context;", "uin", "", "roomId", "", "tableId", "editTagListener", "Lcom/tencent/state/library/tag/IEditTagListener;", "(Landroid/content/Context;Ljava/lang/String;JJLcom/tencent/state/library/tag/IEditTagListener;)V", "getEditTagListener", "()Lcom/tencent/state/library/tag/IEditTagListener;", "setEditTagListener", "(Lcom/tencent/state/library/tag/IEditTagListener;)V", "canShowDeskMateTagContainer", "", "canShowFocusTagContainer", "canShowSyncInSquareContainer", "doEditDeskMateTag", "", "getOperatorStringId", "", "onOperatorClick", "reportPanelShowEvent", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibraryEditDeskMateTagPanel extends LibraryFocusPanel {
    private IEditTagListener editTagListener;
    private final long roomId;
    private final long tableId;
    private final String uin;

    public /* synthetic */ LibraryEditDeskMateTagPanel(Context context, String str, long j3, long j16, IEditTagListener iEditTagListener, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, j3, j16, (i3 & 16) != 0 ? null : iEditTagListener);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001e, code lost:
    
        if (r4 != false) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void doEditDeskMateTag() {
        boolean z16;
        IEditTagListener iEditTagListener;
        boolean isBlank;
        boolean isBlank2;
        final String currentDeskMateTagId = getCurrentDeskMateTagId();
        final String currentDeskMateTag = getCurrentDeskMateTag();
        boolean z17 = false;
        if (currentDeskMateTagId != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(currentDeskMateTagId);
            if (!isBlank2) {
                z16 = false;
                if (!z16) {
                    if (currentDeskMateTag != null) {
                        isBlank = StringsKt__StringsJVMKt.isBlank(currentDeskMateTag);
                    }
                    z17 = true;
                    if (!z17) {
                        VasLibraryRoomService.INSTANCE.editTag(currentDeskMateTagId, new ResultCallback<Boolean>() { // from class: com.tencent.state.library.tag.LibraryEditDeskMateTagPanel$doEditDeskMateTag$1
                            @Override // com.tencent.state.service.ResultCallback
                            public void onResultFailure(int i3, String str, String str2) {
                                ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
                            }

                            @Override // com.tencent.state.service.ResultCallback
                            public /* bridge */ /* synthetic */ void onResultSuccess(Boolean bool) {
                                onResultSuccess(bool.booleanValue());
                            }

                            @Override // com.tencent.state.service.ResultCallback
                            public void onResultFailure(int error, String message) {
                                IEditTagListener editTagListener = LibraryEditDeskMateTagPanel.this.getEditTagListener();
                                if (editTagListener != null) {
                                    if (message == null) {
                                        message = "";
                                    }
                                    editTagListener.onEditTagFailed(error, message);
                                }
                            }

                            public void onResultSuccess(boolean result) {
                                String str;
                                IEditTagListener editTagListener = LibraryEditDeskMateTagPanel.this.getEditTagListener();
                                if (editTagListener != null) {
                                    str = LibraryEditDeskMateTagPanel.this.uin;
                                    editTagListener.onEditTagSuccess(str, new CommonTagInfo(currentDeskMateTagId, currentDeskMateTag));
                                }
                            }
                        });
                        return;
                    }
                }
                iEditTagListener = this.editTagListener;
                if (iEditTagListener == null) {
                    iEditTagListener.onEditTagFailed(-1, "");
                    return;
                }
                return;
            }
        }
        z16 = true;
        if (!z16) {
        }
        iEditTagListener = this.editTagListener;
        if (iEditTagListener == null) {
        }
    }

    @Override // com.tencent.state.library.tag.LibraryFocusPanel, com.tencent.state.common.tag.BaseTagPanel
    protected boolean canShowDeskMateTagContainer() {
        return true;
    }

    @Override // com.tencent.state.common.tag.BaseTagPanel
    protected boolean canShowFocusTagContainer() {
        return false;
    }

    @Override // com.tencent.state.common.tag.BaseTagPanel
    protected boolean canShowSyncInSquareContainer() {
        return false;
    }

    public final IEditTagListener getEditTagListener() {
        return this.editTagListener;
    }

    @Override // com.tencent.state.library.tag.LibraryFocusPanel, com.tencent.state.common.tag.BaseTagPanel
    protected int getOperatorStringId() {
        return R.string.xch;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.library.tag.LibraryFocusPanel, com.tencent.state.common.tag.BaseTagPanel
    public void onOperatorClick() {
        doEditDeskMateTag();
    }

    public final void setEditTagListener(IEditTagListener iEditTagListener) {
        this.editTagListener = iEditTagListener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LibraryEditDeskMateTagPanel(Context context, String uin, long j3, long j16, IEditTagListener iEditTagListener) {
        super(context, false, false, false, j3, j16, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.uin = uin;
        this.roomId = j3;
        this.tableId = j16;
        this.editTagListener = iEditTagListener;
    }

    @Override // com.tencent.state.common.tag.BaseTagPanel
    protected void reportPanelShowEvent() {
    }
}
