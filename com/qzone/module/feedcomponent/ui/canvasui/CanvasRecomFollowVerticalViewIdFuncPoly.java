package com.qzone.module.feedcomponent.ui.canvasui;

import android.view.MotionEvent;
import com.qzone.canvasui.widget.RichCanvasTextArea;
import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.func.DittoIdFunc;
import com.tencent.ditto.func.DittoIdFuncPoly;
import com.tencent.ditto.func.DittoIdFuncPolyProxy;
import com.tencent.ditto.widget.DittoImageArea;
import com.tencent.ditto.widget.DittoListArea;
import com.tencent.ditto.widget.LinearAreaLayout;
import com.tencent.ditto.widget.RelativeAreaLayout;
import java.util.HashMap;

/* loaded from: classes39.dex */
public class CanvasRecomFollowVerticalViewIdFuncPoly extends DittoIdFuncPolyProxy {

    /* loaded from: classes39.dex */
    private static class Holder {
        private static final DittoIdFuncPoly ID_FUNC_POLY;

        static {
            HashMap hashMap = new HashMap();
            hashMap.put("qzone_feed_recomm_follow_morecontainer", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecomFollowVerticalViewIdFuncPoly.Holder.1
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecomFollowVerticalView) dittoAreaView).qzone_feed_recomm_follow_morecontainer = (LinearAreaLayout) dittoArea;
                }
            });
            hashMap.put("qzone_feed_recomm_follow_title", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecomFollowVerticalViewIdFuncPoly.Holder.2
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecomFollowVerticalView) dittoAreaView).qzone_feed_recomm_follow_title = (RichCanvasTextArea) dittoArea;
                }
            });
            hashMap.put("qzone_feed_recomm_follow_dropdown_btn", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecomFollowVerticalViewIdFuncPoly.Holder.3
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecomFollowVerticalView) dittoAreaView).qzone_feed_recomm_follow_dropdown_btn = (DittoImageArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecomFollowVerticalViewIdFuncPoly.Holder.3.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasRecomFollowVerticalView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("qzone_feed_recomm_follow_more_icon", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecomFollowVerticalViewIdFuncPoly.Holder.4
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecomFollowVerticalView) dittoAreaView).qzone_feed_recomm_follow_more_icon = (DittoImageArea) dittoArea;
                }
            });
            hashMap.put("feed_recommend_follow_layout", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecomFollowVerticalViewIdFuncPoly.Holder.5
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecomFollowVerticalView) dittoAreaView).feed_recommend_follow_layout = (LinearAreaLayout) dittoArea;
                }
            });
            hashMap.put("qzone_feed_recomm_follow_moreview", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecomFollowVerticalViewIdFuncPoly.Holder.6
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecomFollowVerticalView) dittoAreaView).qzone_feed_recomm_follow_moreview = (RelativeAreaLayout) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecomFollowVerticalViewIdFuncPoly.Holder.6.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasRecomFollowVerticalView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("recomlist", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecomFollowVerticalViewIdFuncPoly.Holder.7
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecomFollowVerticalView) dittoAreaView).recomlist = (DittoListArea) dittoArea;
                }
            });
            hashMap.put("qzone_feed_recomm_follow_titlebar", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecomFollowVerticalViewIdFuncPoly.Holder.8
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecomFollowVerticalView) dittoAreaView).qzone_feed_recomm_follow_titlebar = (RelativeAreaLayout) dittoArea;
                }
            });
            hashMap.put("qzone_feed_recomm_follow_more_text", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecomFollowVerticalViewIdFuncPoly.Holder.9
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasRecomFollowVerticalView) dittoAreaView).qzone_feed_recomm_follow_more_text = (RichCanvasTextArea) dittoArea;
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
