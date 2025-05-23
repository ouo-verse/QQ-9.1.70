package com.tencent.mobileqq.nearby.now.view;

import com.tencent.mobileqq.nearby.now.model.Comments;

/* compiled from: P */
/* loaded from: classes33.dex */
public interface b {
    void addCommentInView(Comments.Comment comment);

    void hideInputKeyboard();

    void hideLoading();

    void publishCommentFailed(Comments.Comment comment, int i3, String str);

    void removeCommentDirectly(Comments.Comment comment);

    void showBadNetworkConnection();

    void showDataInView(Comments comments);

    void showLoading();

    void showToast(String str);
}
