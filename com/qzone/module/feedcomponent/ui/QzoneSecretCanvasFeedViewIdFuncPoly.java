package com.qzone.module.feedcomponent.ui;

import android.view.MotionEvent;
import com.qzone.canvasui.widget.AsyncCanvasImageArea;
import com.qzone.canvasui.widget.RichCanvasTextArea;
import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.func.DittoIdFunc;
import com.tencent.ditto.func.DittoIdFuncPoly;
import com.tencent.ditto.func.DittoIdFuncPolyProxy;
import com.tencent.ditto.widget.DittoImageArea;
import com.tencent.ditto.widget.DittoTextArea;
import java.util.HashMap;

/* loaded from: classes39.dex */
public class QzoneSecretCanvasFeedViewIdFuncPoly extends DittoIdFuncPolyProxy {

    /* loaded from: classes39.dex */
    private static class Holder {
        private static final DittoIdFuncPoly ID_FUNC_POLY;

        static {
            HashMap hashMap = new HashMap();
            hashMap.put("image", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.QzoneSecretCanvasFeedViewIdFuncPoly.Holder.1
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((QzoneSecretCanvasFeedView) dittoAreaView).image = (AsyncCanvasImageArea) dittoArea;
                }
            });
            hashMap.put("right_planet", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.QzoneSecretCanvasFeedViewIdFuncPoly.Holder.2
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((QzoneSecretCanvasFeedView) dittoAreaView).right_planet = (DittoImageArea) dittoArea;
                }
            });
            hashMap.put("down_container", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.QzoneSecretCanvasFeedViewIdFuncPoly.Holder.3
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.QzoneSecretCanvasFeedViewIdFuncPoly.Holder.3.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((QzoneSecretCanvasFeedView) dittoAreaView).onDissClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("up_button", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.QzoneSecretCanvasFeedViewIdFuncPoly.Holder.4
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((QzoneSecretCanvasFeedView) dittoAreaView).up_button = (AsyncCanvasImageArea) dittoArea;
                }
            });
            hashMap.put("secret_content", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.QzoneSecretCanvasFeedViewIdFuncPoly.Holder.5
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((QzoneSecretCanvasFeedView) dittoAreaView).secret_content = (RichCanvasTextArea) dittoArea;
                }
            });
            hashMap.put("title_container", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.QzoneSecretCanvasFeedViewIdFuncPoly.Holder.6
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((QzoneSecretCanvasFeedView) dittoAreaView).title_container = dittoArea;
                }
            });
            hashMap.put("audio_container", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.QzoneSecretCanvasFeedViewIdFuncPoly.Holder.7
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((QzoneSecretCanvasFeedView) dittoAreaView).audio_container = dittoArea;
                }
            });
            hashMap.put("audio_length", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.QzoneSecretCanvasFeedViewIdFuncPoly.Holder.8
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((QzoneSecretCanvasFeedView) dittoAreaView).audio_length = (DittoTextArea) dittoArea;
                }
            });
            hashMap.put("praise_count", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.QzoneSecretCanvasFeedViewIdFuncPoly.Holder.9
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((QzoneSecretCanvasFeedView) dittoAreaView).praise_count = (RichCanvasTextArea) dittoArea;
                }
            });
            hashMap.put("friend_relationship", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.QzoneSecretCanvasFeedViewIdFuncPoly.Holder.10
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((QzoneSecretCanvasFeedView) dittoAreaView).friend_relationship = (DittoTextArea) dittoArea;
                }
            });
            hashMap.put("root_container", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.QzoneSecretCanvasFeedViewIdFuncPoly.Holder.11
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((QzoneSecretCanvasFeedView) dittoAreaView).root_container = dittoArea;
                }
            });
            hashMap.put("operation_divider", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.QzoneSecretCanvasFeedViewIdFuncPoly.Holder.12
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((QzoneSecretCanvasFeedView) dittoAreaView).operation_divider = dittoArea;
                }
            });
            hashMap.put("up_container", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.QzoneSecretCanvasFeedViewIdFuncPoly.Holder.13
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.QzoneSecretCanvasFeedViewIdFuncPoly.Holder.13.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((QzoneSecretCanvasFeedView) dittoAreaView).onPraiseClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("additional_infos", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.QzoneSecretCanvasFeedViewIdFuncPoly.Holder.14
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((QzoneSecretCanvasFeedView) dittoAreaView).additional_infos = (RichCanvasTextArea) dittoArea;
                }
            });
            hashMap.put("down_button", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.QzoneSecretCanvasFeedViewIdFuncPoly.Holder.15
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((QzoneSecretCanvasFeedView) dittoAreaView).down_button = (AsyncCanvasImageArea) dittoArea;
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
