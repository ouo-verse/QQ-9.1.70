package com.qzone.module.feedcomponent.ui.canvasui;

import android.view.MotionEvent;
import com.qzone.canvasui.widget.AsyncCanvasImageArea;
import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.func.DittoIdFunc;
import com.tencent.ditto.func.DittoIdFuncPoly;
import com.tencent.ditto.func.DittoIdFuncPolyProxy;
import com.tencent.ditto.widget.DittoButtonArea;
import com.tencent.ditto.widget.DittoListArea;
import com.tencent.ditto.widget.DittoTextArea;
import com.tencent.qqmini.sdk.launcher.model.CrashRtInfoHolder;
import java.util.HashMap;

/* loaded from: classes39.dex */
public class CanvasFriendPlayingCardViewIdFuncPoly extends DittoIdFuncPolyProxy {

    /* loaded from: classes39.dex */
    private static class Holder {
        private static final DittoIdFuncPoly ID_FUNC_POLY;

        static {
            HashMap hashMap = new HashMap();
            hashMap.put("game_logo", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFriendPlayingCardViewIdFuncPoly.Holder.1
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasFriendPlayingCardView) dittoAreaView).mGameLogo = (AsyncCanvasImageArea) dittoArea;
                }
            });
            hashMap.put(CrashRtInfoHolder.BeaconKey.GAME_NAME, new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFriendPlayingCardViewIdFuncPoly.Holder.2
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasFriendPlayingCardView) dittoAreaView).mGameName = (DittoTextArea) dittoArea;
                }
            });
            hashMap.put("game_rank_text", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFriendPlayingCardViewIdFuncPoly.Holder.3
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasFriendPlayingCardView) dittoAreaView).mGameRankText = (DittoTextArea) dittoArea;
                }
            });
            hashMap.put("user_rank_text", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFriendPlayingCardViewIdFuncPoly.Holder.4
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasFriendPlayingCardView) dittoAreaView).mUserRankText = (DittoTextArea) dittoArea;
                }
            });
            hashMap.put("card_root", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFriendPlayingCardViewIdFuncPoly.Holder.5
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasFriendPlayingCardView) dittoAreaView).mRoot = dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFriendPlayingCardViewIdFuncPoly.Holder.5.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasFriendPlayingCardView) dittoAreaView).onClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("bg_logo", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFriendPlayingCardViewIdFuncPoly.Holder.6
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasFriendPlayingCardView) dittoAreaView).bgLogo = (AsyncCanvasImageArea) dittoArea;
                }
            });
            hashMap.put("jump_button", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFriendPlayingCardViewIdFuncPoly.Holder.7
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasFriendPlayingCardView) dittoAreaView).mJumpButton = (DittoButtonArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFriendPlayingCardViewIdFuncPoly.Holder.7.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasFriendPlayingCardView) dittoAreaView).onClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("player_counts", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFriendPlayingCardViewIdFuncPoly.Holder.8
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasFriendPlayingCardView) dittoAreaView).mPlayerCounts = (DittoTextArea) dittoArea;
                }
            });
            hashMap.put("avatars", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasFriendPlayingCardViewIdFuncPoly.Holder.9
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasFriendPlayingCardView) dittoAreaView).mAvatars = (DittoListArea) dittoArea;
                }
            });
            ID_FUNC_POLY = new DittoIdFuncPoly(hashMap);
        }

        Holder() {
        }
    }

    @Override // com.tencent.ditto.func.DittoIdFuncPolyProxy
    protected DittoIdFuncPoly getIdFuncPoly() {
        return Holder.ID_FUNC_POLY;
    }
}
