package com.qzone.module.feedcomponent.ui.canvasui;

import android.view.MotionEvent;
import com.qzone.canvasui.widget.AsyncCanvasImageArea;
import com.qzone.canvasui.widget.CanvasAvatarArea;
import com.qzone.canvasui.widget.RichCanvasTextArea;
import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.func.DittoIdFunc;
import com.tencent.ditto.func.DittoIdFuncPoly;
import com.tencent.ditto.func.DittoIdFuncPolyProxy;
import com.tencent.ditto.widget.LinearAreaLayout;
import com.tencent.ditto.widget.RelativeAreaLayout;
import java.util.HashMap;

/* loaded from: classes39.dex */
public class CampusShardCardViewIdFuncPoly extends DittoIdFuncPolyProxy {

    /* loaded from: classes39.dex */
    private static class Holder {
        private static final DittoIdFuncPoly ID_FUNC_POLY;

        static {
            HashMap hashMap = new HashMap();
            hashMap.put("answer_info", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CampusShardCardViewIdFuncPoly.Holder.1
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CampusShardCardView) dittoAreaView).answer_info = (RichCanvasTextArea) dittoArea;
                }
            });
            hashMap.put("share_module_layout", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CampusShardCardViewIdFuncPoly.Holder.2
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CampusShardCardView) dittoAreaView).share_module_layout = (LinearAreaLayout) dittoArea;
                }
            });
            hashMap.put("read_info", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CampusShardCardViewIdFuncPoly.Holder.3
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CampusShardCardView) dittoAreaView).read_info = (RichCanvasTextArea) dittoArea;
                }
            });
            hashMap.put("avatar", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CampusShardCardViewIdFuncPoly.Holder.4
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CampusShardCardView) dittoAreaView).avatar = (CanvasAvatarArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CampusShardCardViewIdFuncPoly.Holder.4.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CampusShardCardView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("title", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CampusShardCardViewIdFuncPoly.Holder.5
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CampusShardCardView) dittoAreaView).title = (RichCanvasTextArea) dittoArea;
                }
            });
            hashMap.put("answer_count", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CampusShardCardViewIdFuncPoly.Holder.6
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CampusShardCardView) dittoAreaView).answer_count = (RichCanvasTextArea) dittoArea;
                }
            });
            hashMap.put("cover", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CampusShardCardViewIdFuncPoly.Holder.7
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CampusShardCardView) dittoAreaView).cover = (AsyncCanvasImageArea) dittoArea;
                }
            });
            hashMap.put("sharecard_root", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CampusShardCardViewIdFuncPoly.Holder.8
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CampusShardCardView) dittoAreaView).sharecard_root = (RelativeAreaLayout) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CampusShardCardViewIdFuncPoly.Holder.8.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CampusShardCardView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("background", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CampusShardCardViewIdFuncPoly.Holder.9
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CampusShardCardView) dittoAreaView).background = (AsyncCanvasImageArea) dittoArea;
                }
            });
            hashMap.put("module_img", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CampusShardCardViewIdFuncPoly.Holder.10
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CampusShardCardView) dittoAreaView).module_img = (AsyncCanvasImageArea) dittoArea;
                }
            });
            hashMap.put("share_desc", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CampusShardCardViewIdFuncPoly.Holder.11
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CampusShardCardView) dittoAreaView).share_desc = (RichCanvasTextArea) dittoArea;
                }
            });
            hashMap.put("module_name", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CampusShardCardViewIdFuncPoly.Holder.12
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CampusShardCardView) dittoAreaView).module_name = (RichCanvasTextArea) dittoArea;
                }
            });
            hashMap.put("read_count", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CampusShardCardViewIdFuncPoly.Holder.13
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CampusShardCardView) dittoAreaView).read_count = (RichCanvasTextArea) dittoArea;
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
