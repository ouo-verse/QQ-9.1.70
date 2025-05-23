package com.tencent.state.library.focus;

import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.resource.IResourceCallback;
import com.tencent.state.template.data.User;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u001a\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&J \u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H&\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/library/focus/FocusBaseListener;", "", "notifyLibraryMeSitDown", "", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/template/data/User;", "notifyLibraryMeStandUp", "tableId", "", "uin", "onBackClick", "onEndFocusClick", "focusTimeText", "", "recordAvatar", "resource", "Lcom/tencent/state/square/data/Resource;", "callback", "Lcom/tencent/state/square/resource/IResourceCallback;", "updateLibraryItemVisible", "id", "type", "", NodeProps.VISIBLE, "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public interface FocusBaseListener {
    void notifyLibraryMeSitDown(User user);

    void notifyLibraryMeStandUp(long tableId, long uin);

    void onBackClick();

    void onEndFocusClick(String focusTimeText);

    void recordAvatar(Resource resource, IResourceCallback callback);

    void updateLibraryItemVisible(String id5, int type, boolean visible);
}
