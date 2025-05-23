package com.tencent.qqlive.module.videoreport.utils;

import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ViewCompatUtils {
    private static final ViewCompatBaseImpl IMPL = new ViewCompatApi21Impl();

    /* compiled from: P */
    @RequiresApi(api = 18)
    /* loaded from: classes22.dex */
    private static class ViewCompatApi18Impl extends ViewCompatBaseImpl {
        ViewCompatApi18Impl() {
            super();
        }

        @Override // com.tencent.qqlive.module.videoreport.utils.ViewCompatUtils.ViewCompatBaseImpl
        public boolean getClipChildren(ViewGroup viewGroup) {
            return viewGroup.getClipChildren();
        }
    }

    /* compiled from: P */
    @RequiresApi(api = 19)
    /* loaded from: classes22.dex */
    private static class ViewCompatApi19Impl extends ViewCompatApi18Impl {
        ViewCompatApi19Impl() {
            super();
        }

        @Override // com.tencent.qqlive.module.videoreport.utils.ViewCompatUtils.ViewCompatBaseImpl
        public boolean isAttachedToWindow(View view) {
            return view.isAttachedToWindow();
        }

        @Override // com.tencent.qqlive.module.videoreport.utils.ViewCompatUtils.ViewCompatBaseImpl
        public boolean isLaidOut(View view) {
            return view.isLaidOut();
        }
    }

    /* compiled from: P */
    @RequiresApi(api = 21)
    /* loaded from: classes22.dex */
    private static class ViewCompatApi21Impl extends ViewCompatApi19Impl {
        ViewCompatApi21Impl() {
            super();
        }

        @Override // com.tencent.qqlive.module.videoreport.utils.ViewCompatUtils.ViewCompatBaseImpl
        public boolean getClipToPadding(ViewGroup viewGroup) {
            return viewGroup.getClipToPadding();
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class ViewCompatBaseImpl {
        private static final String TAG = "ViewCompatBaseImpl";
        private static final Integer FLAG_CLIP_TO_PADDING = (Integer) ReflectUtils.getField((Class<?>) ViewGroup.class, "FLAG_CLIP_TO_PADDING");
        private static final Integer FLAG_CLIP_CHILDREN = (Integer) ReflectUtils.getField((Class<?>) ViewGroup.class, "FLAG_CLIP_CHILDREN");

        ViewCompatBaseImpl() {
        }

        private boolean hasBooleanFlag(ViewGroup viewGroup, Integer num) {
            String num2;
            Integer num3 = (Integer) ReflectUtils.getField(ViewGroup.class, "mGroupFlags", viewGroup);
            if (VideoReportInner.getInstance().isDebugMode()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("hasBooleanFlag: groupFlags = ");
                String str = "null";
                if (num3 == null) {
                    num2 = "null";
                } else {
                    num2 = num3.toString();
                }
                sb5.append(num2);
                sb5.append(", flag = ");
                if (num != null) {
                    str = num.toString();
                }
                sb5.append(str);
                Log.d(TAG, sb5.toString());
            }
            if (num3 == null || num == null || (num3.intValue() & num.intValue()) != num.intValue()) {
                return false;
            }
            return true;
        }

        public boolean getClipChildren(ViewGroup viewGroup) {
            return hasBooleanFlag(viewGroup, FLAG_CLIP_CHILDREN);
        }

        public boolean getClipToPadding(ViewGroup viewGroup) {
            return hasBooleanFlag(viewGroup, FLAG_CLIP_TO_PADDING);
        }

        public boolean isAttachedToWindow(View view) {
            if (ReflectUtils.getField(View.class, "mAttachInfo", view) != null) {
                return true;
            }
            return false;
        }

        public boolean isLaidOut(View view) {
            if (view.getWidth() > 0 && view.getHeight() > 0) {
                return true;
            }
            return false;
        }
    }

    public static boolean getClipChildren(ViewGroup viewGroup) {
        return IMPL.getClipChildren(viewGroup);
    }

    public static boolean getClipToPadding(ViewGroup viewGroup) {
        return IMPL.getClipToPadding(viewGroup);
    }

    public static boolean isAttachedToWindow(View view) {
        return IMPL.isAttachedToWindow(view);
    }

    public static boolean isLaidOut(View view) {
        return IMPL.isLaidOut(view);
    }
}
