package com.tencent.mobileqq.qqecommerce.biz.consumer.api;

import android.view.ViewGroup;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0002\u0016\u0017J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0005H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\u001a\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012H&\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/consumer/api/IQQGoodsViewModel;", "", "onVideoProgressChange", "", "progress", "", "duration", "onWrapperViewAppear", "isContinuation", "", "onWrapperViewDisappear", "sendTopViewEvent", "action", "params", "Lorg/json/JSONObject;", "sendXingHuanCardEvent", "setTopWrapperView", "viewGroup", "Landroid/view/ViewGroup;", "setWrapperView", "wrapperView", "bigWrapperView", "ECBusinessID", "ECContentScene", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public interface IQQGoodsViewModel {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/consumer/api/IQQGoodsViewModel$ECBusinessID;", "", "()V", QQWinkConstants.ENTRY_BUSINESS_KANDIAN, "", "LITTLE_WORLD", "UNKNOWN", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class ECBusinessID {

        @NotNull
        public static final ECBusinessID INSTANCE = new ECBusinessID();
        public static final int KANDIAN = 1;
        public static final int LITTLE_WORLD = 2;
        public static final int UNKNOWN = 0;

        ECBusinessID() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/consumer/api/IQQGoodsViewModel$ECContentScene;", "", "()V", "ARTICLE", "", "COMMENT", "PICS", "SCENE_GAME_TAB", "SCENE_SEARCH", "SCENE_SHARE_PAGE", "TOP_VIEW", "UNKNOWN", "VIDEO", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class ECContentScene {
        public static final int ARTICLE = 1;
        public static final int COMMENT = 4;

        @NotNull
        public static final ECContentScene INSTANCE = new ECContentScene();
        public static final int PICS = 3;
        public static final int SCENE_GAME_TAB = 7;
        public static final int SCENE_SEARCH = 6;
        public static final int SCENE_SHARE_PAGE = 5;
        public static final int TOP_VIEW = 8;
        public static final int UNKNOWN = 0;
        public static final int VIDEO = 2;

        ECContentScene() {
        }
    }

    void onVideoProgressChange(int progress, int duration);

    void onWrapperViewAppear(boolean isContinuation);

    void onWrapperViewDisappear();

    void sendTopViewEvent(int action, @NotNull JSONObject params);

    void sendXingHuanCardEvent(int action);

    void setTopWrapperView(@NotNull ViewGroup viewGroup);

    void setWrapperView(@NotNull ViewGroup wrapperView, @Nullable ViewGroup bigWrapperView);
}
