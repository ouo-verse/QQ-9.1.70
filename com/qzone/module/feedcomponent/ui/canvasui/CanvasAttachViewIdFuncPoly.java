package com.qzone.module.feedcomponent.ui.canvasui;

import android.view.MotionEvent;
import com.qzone.canvasui.widget.RichCanvasTextArea;
import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.func.DittoIdFunc;
import com.tencent.ditto.func.DittoIdFuncPoly;
import com.tencent.ditto.func.DittoIdFuncPolyProxy;
import com.tencent.ditto.widget.LinearAreaLayout;
import java.util.HashMap;

/* loaded from: classes39.dex */
public class CanvasAttachViewIdFuncPoly extends DittoIdFuncPolyProxy {

    /* loaded from: classes39.dex */
    private static class Holder {
        private static final DittoIdFuncPoly ID_FUNC_POLY;

        static {
            HashMap hashMap = new HashMap();
            hashMap.put("feed_attach_remark", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasAttachViewIdFuncPoly.Holder.1
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasAttachView) dittoAreaView).feed_attach_remark = (RichCanvasTextArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasAttachViewIdFuncPoly.Holder.1.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasAttachView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("feed_attach_shootinfo", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasAttachViewIdFuncPoly.Holder.2
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasAttachView) dittoAreaView).feed_attach_shootinfo = (RichCanvasTextArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasAttachViewIdFuncPoly.Holder.2.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasAttachView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("feed_attach_root", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasAttachViewIdFuncPoly.Holder.3
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasAttachView) dittoAreaView).feed_attach_root = (LinearAreaLayout) dittoArea;
                }
            });
            hashMap.put("feed_attach_titleinfo", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasAttachViewIdFuncPoly.Holder.4
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasAttachView) dittoAreaView).feed_attach_titleinfo = (RichCanvasTextArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasAttachViewIdFuncPoly.Holder.4.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasAttachView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("feed_attach_refer", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasAttachViewIdFuncPoly.Holder.5
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasAttachView) dittoAreaView).feed_attach_refer = (RichCanvasTextArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasAttachViewIdFuncPoly.Holder.5.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasAttachView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("feed_attach_lbs", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasAttachViewIdFuncPoly.Holder.6
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasAttachView) dittoAreaView).feed_attach_lbs = (RichCanvasTextArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasAttachViewIdFuncPoly.Holder.6.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasAttachView) dittoAreaView).onCanvasAreaClicked(dittoArea2, motionEvent, obj);
                        }
                    };
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
