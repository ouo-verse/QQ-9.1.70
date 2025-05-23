package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class AccessibilityNodeInfoCompat {
    public static final int ACTION_ACCESSIBILITY_FOCUS = 64;
    public static final String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
    public static final String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
    public static final String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
    public static final String ACTION_ARGUMENT_SELECTION_END_INT = "ACTION_ARGUMENT_SELECTION_END_INT";
    public static final String ACTION_ARGUMENT_SELECTION_START_INT = "ACTION_ARGUMENT_SELECTION_START_INT";
    public static final String ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE";
    public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 128;
    public static final int ACTION_CLEAR_FOCUS = 2;
    public static final int ACTION_CLEAR_SELECTION = 8;
    public static final int ACTION_CLICK = 16;
    public static final int ACTION_COPY = 16384;
    public static final int ACTION_CUT = 65536;
    public static final int ACTION_FOCUS = 1;
    public static final int ACTION_LONG_CLICK = 32;
    public static final int ACTION_NEXT_AT_MOVEMENT_GRANULARITY = 256;
    public static final int ACTION_NEXT_HTML_ELEMENT = 1024;
    public static final int ACTION_PASTE = 32768;
    public static final int ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = 512;
    public static final int ACTION_PREVIOUS_HTML_ELEMENT = 2048;
    public static final int ACTION_SCROLL_BACKWARD = 8192;
    public static final int ACTION_SCROLL_FORWARD = 4096;
    public static final int ACTION_SELECT = 4;
    public static final int ACTION_SET_SELECTION = 131072;
    public static final int ACTION_SET_TEXT = 2097152;
    public static final int FOCUS_ACCESSIBILITY = 2;
    public static final int FOCUS_INPUT = 1;
    private static final AccessibilityNodeInfoImpl IMPL = new AccessibilityNodeInfoKitKatImpl();
    public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
    public static final int MOVEMENT_GRANULARITY_LINE = 4;
    public static final int MOVEMENT_GRANULARITY_PAGE = 16;
    public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
    public static final int MOVEMENT_GRANULARITY_WORD = 2;
    private final Object mInfo;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class AccessibilityActionCompat {
        private final Object mAction;

        AccessibilityActionCompat(Object obj) {
            this.mAction = obj;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class AccessibilityNodeInfoIcsImpl extends AccessibilityNodeInfoStubImpl {
        AccessibilityNodeInfoIcsImpl() {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void addAction(Object obj, int i3) {
            AccessibilityNodeInfoCompatIcs.addAction(obj, i3);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void addChild(Object obj, View view) {
            AccessibilityNodeInfoCompatIcs.addChild(obj, view);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public List<Object> findAccessibilityNodeInfosByText(Object obj, String str) {
            return AccessibilityNodeInfoCompatIcs.findAccessibilityNodeInfosByText(obj, str);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getActions(Object obj) {
            return AccessibilityNodeInfoCompatIcs.getActions(obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void getBoundsInParent(Object obj, Rect rect) {
            AccessibilityNodeInfoCompatIcs.getBoundsInParent(obj, rect);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void getBoundsInScreen(Object obj, Rect rect) {
            AccessibilityNodeInfoCompatIcs.getBoundsInScreen(obj, rect);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public Object getChild(Object obj, int i3) {
            return AccessibilityNodeInfoCompatIcs.getChild(obj, i3);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getChildCount(Object obj) {
            return AccessibilityNodeInfoCompatIcs.getChildCount(obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public CharSequence getClassName(Object obj) {
            return AccessibilityNodeInfoCompatIcs.getClassName(obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public CharSequence getContentDescription(Object obj) {
            return AccessibilityNodeInfoCompatIcs.getContentDescription(obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public CharSequence getPackageName(Object obj) {
            return AccessibilityNodeInfoCompatIcs.getPackageName(obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public Object getParent(Object obj) {
            return AccessibilityNodeInfoCompatIcs.getParent(obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public CharSequence getText(Object obj) {
            return AccessibilityNodeInfoCompatIcs.getText(obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getWindowId(Object obj) {
            return AccessibilityNodeInfoCompatIcs.getWindowId(obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isCheckable(Object obj) {
            return AccessibilityNodeInfoCompatIcs.isCheckable(obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isChecked(Object obj) {
            return AccessibilityNodeInfoCompatIcs.isChecked(obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isClickable(Object obj) {
            return AccessibilityNodeInfoCompatIcs.isClickable(obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isEnabled(Object obj) {
            return AccessibilityNodeInfoCompatIcs.isEnabled(obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isFocusable(Object obj) {
            return AccessibilityNodeInfoCompatIcs.isFocusable(obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isFocused(Object obj) {
            return AccessibilityNodeInfoCompatIcs.isFocused(obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isLongClickable(Object obj) {
            return AccessibilityNodeInfoCompatIcs.isLongClickable(obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isPassword(Object obj) {
            return AccessibilityNodeInfoCompatIcs.isPassword(obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isScrollable(Object obj) {
            return AccessibilityNodeInfoCompatIcs.isScrollable(obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isSelected(Object obj) {
            return AccessibilityNodeInfoCompatIcs.isSelected(obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public Object obtain() {
            return AccessibilityNodeInfoCompatIcs.obtain();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean performAction(Object obj, int i3) {
            return AccessibilityNodeInfoCompatIcs.performAction(obj, i3);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void recycle(Object obj) {
            AccessibilityNodeInfoCompatIcs.recycle(obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setBoundsInParent(Object obj, Rect rect) {
            AccessibilityNodeInfoCompatIcs.setBoundsInParent(obj, rect);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setBoundsInScreen(Object obj, Rect rect) {
            AccessibilityNodeInfoCompatIcs.setBoundsInScreen(obj, rect);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setCheckable(Object obj, boolean z16) {
            AccessibilityNodeInfoCompatIcs.setCheckable(obj, z16);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setChecked(Object obj, boolean z16) {
            AccessibilityNodeInfoCompatIcs.setChecked(obj, z16);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setClassName(Object obj, CharSequence charSequence) {
            AccessibilityNodeInfoCompatIcs.setClassName(obj, charSequence);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setClickable(Object obj, boolean z16) {
            AccessibilityNodeInfoCompatIcs.setClickable(obj, z16);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setContentDescription(Object obj, CharSequence charSequence) {
            AccessibilityNodeInfoCompatIcs.setContentDescription(obj, charSequence);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setEnabled(Object obj, boolean z16) {
            AccessibilityNodeInfoCompatIcs.setEnabled(obj, z16);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setFocusable(Object obj, boolean z16) {
            AccessibilityNodeInfoCompatIcs.setFocusable(obj, z16);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setFocused(Object obj, boolean z16) {
            AccessibilityNodeInfoCompatIcs.setFocused(obj, z16);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setLongClickable(Object obj, boolean z16) {
            AccessibilityNodeInfoCompatIcs.setLongClickable(obj, z16);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setPackageName(Object obj, CharSequence charSequence) {
            AccessibilityNodeInfoCompatIcs.setPackageName(obj, charSequence);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setParent(Object obj, View view) {
            AccessibilityNodeInfoCompatIcs.setParent(obj, view);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setPassword(Object obj, boolean z16) {
            AccessibilityNodeInfoCompatIcs.setPassword(obj, z16);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setScrollable(Object obj, boolean z16) {
            AccessibilityNodeInfoCompatIcs.setScrollable(obj, z16);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setSelected(Object obj, boolean z16) {
            AccessibilityNodeInfoCompatIcs.setSelected(obj, z16);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setSource(Object obj, View view) {
            AccessibilityNodeInfoCompatIcs.setSource(obj, view);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setText(Object obj, CharSequence charSequence) {
            AccessibilityNodeInfoCompatIcs.setText(obj, charSequence);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void addAction(Object obj, int i3, CharSequence charSequence) {
            if (Integer.bitCount(i3) == 1) {
                addAction(obj, i3);
            }
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public Object obtain(View view) {
            return AccessibilityNodeInfoCompatIcs.obtain(view);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public Object obtain(Object obj) {
            return AccessibilityNodeInfoCompatIcs.obtain(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface AccessibilityNodeInfoImpl {
        void addAction(Object obj, int i3);

        void addAction(Object obj, int i3, CharSequence charSequence);

        void addChild(Object obj, View view);

        void addChild(Object obj, View view, int i3);

        List<Object> findAccessibilityNodeInfosByText(Object obj, String str);

        Object findFocus(Object obj, int i3);

        Object focusSearch(Object obj, int i3);

        List<Object> getActionList(Object obj);

        int getActions(Object obj);

        void getBoundsInParent(Object obj, Rect rect);

        void getBoundsInScreen(Object obj, Rect rect);

        Object getChild(Object obj, int i3);

        int getChildCount(Object obj);

        CharSequence getClassName(Object obj);

        Object getCollectionInfo(Object obj);

        int getCollectionInfoColumnCount(Object obj);

        int getCollectionInfoRowCount(Object obj);

        int getCollectionItemColumnIndex(Object obj);

        int getCollectionItemColumnSpan(Object obj);

        Object getCollectionItemInfo(Object obj);

        int getCollectionItemRowIndex(Object obj);

        int getCollectionItemRowSpan(Object obj);

        CharSequence getContentDescription(Object obj);

        int getLiveRegion(Object obj);

        int getMovementGranularities(Object obj);

        CharSequence getPackageName(Object obj);

        Object getParent(Object obj);

        Object getRangeInfo(Object obj);

        CharSequence getText(Object obj);

        String getViewIdResourceName(Object obj);

        int getWindowId(Object obj);

        boolean isAccessibilityFocused(Object obj);

        boolean isCheckable(Object obj);

        boolean isChecked(Object obj);

        boolean isClickable(Object obj);

        boolean isCollectionInfoHierarchical(Object obj);

        boolean isCollectionItemHeading(Object obj);

        boolean isCollectionItemSelected(Object obj);

        boolean isEnabled(Object obj);

        boolean isFocusable(Object obj);

        boolean isFocused(Object obj);

        boolean isLongClickable(Object obj);

        boolean isPassword(Object obj);

        boolean isScrollable(Object obj);

        boolean isSelected(Object obj);

        boolean isVisibleToUser(Object obj);

        Object obtain();

        Object obtain(View view);

        Object obtain(View view, int i3);

        Object obtain(Object obj);

        Object obtainCollectionInfo(int i3, int i16, boolean z16, int i17);

        Object obtainCollectionItemInfo(int i3, int i16, int i17, int i18, boolean z16, boolean z17);

        boolean performAction(Object obj, int i3);

        boolean performAction(Object obj, int i3, Bundle bundle);

        void recycle(Object obj);

        void setAccessibilityFocused(Object obj, boolean z16);

        void setBoundsInParent(Object obj, Rect rect);

        void setBoundsInScreen(Object obj, Rect rect);

        void setCheckable(Object obj, boolean z16);

        void setChecked(Object obj, boolean z16);

        void setClassName(Object obj, CharSequence charSequence);

        void setClickable(Object obj, boolean z16);

        void setCollectionInfo(Object obj, Object obj2);

        void setCollectionItemInfo(Object obj, Object obj2);

        void setContentDescription(Object obj, CharSequence charSequence);

        void setEnabled(Object obj, boolean z16);

        void setFocusable(Object obj, boolean z16);

        void setFocused(Object obj, boolean z16);

        void setLiveRegion(Object obj, int i3);

        void setLongClickable(Object obj, boolean z16);

        void setMovementGranularities(Object obj, int i3);

        void setPackageName(Object obj, CharSequence charSequence);

        void setParent(Object obj, View view);

        void setParent(Object obj, View view, int i3);

        void setPassword(Object obj, boolean z16);

        void setScrollable(Object obj, boolean z16);

        void setSelected(Object obj, boolean z16);

        void setSource(Object obj, View view);

        void setSource(Object obj, View view, int i3);

        void setText(Object obj, CharSequence charSequence);

        void setViewIdResourceName(Object obj, String str);

        void setVisibleToUser(Object obj, boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class AccessibilityNodeInfoJellybeanImpl extends AccessibilityNodeInfoIcsImpl {
        AccessibilityNodeInfoJellybeanImpl() {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void addChild(Object obj, View view, int i3) {
            AccessibilityNodeInfoCompatJellyBean.addChild(obj, view, i3);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public Object findFocus(Object obj, int i3) {
            return AccessibilityNodeInfoCompatJellyBean.findFocus(obj, i3);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public Object focusSearch(Object obj, int i3) {
            return AccessibilityNodeInfoCompatJellyBean.focusSearch(obj, i3);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getMovementGranularities(Object obj) {
            return AccessibilityNodeInfoCompatJellyBean.getMovementGranularities(obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isAccessibilityFocused(Object obj) {
            return AccessibilityNodeInfoCompatJellyBean.isAccessibilityFocused(obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isVisibleToUser(Object obj) {
            return AccessibilityNodeInfoCompatJellyBean.isVisibleToUser(obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public Object obtain(View view, int i3) {
            return AccessibilityNodeInfoCompatJellyBean.obtain(view, i3);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean performAction(Object obj, int i3, Bundle bundle) {
            return AccessibilityNodeInfoCompatJellyBean.performAction(obj, i3, bundle);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setAccessibilityFocused(Object obj, boolean z16) {
            AccessibilityNodeInfoCompatJellyBean.setAccesibilityFocused(obj, z16);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setMovementGranularities(Object obj, int i3) {
            AccessibilityNodeInfoCompatJellyBean.setMovementGranularities(obj, i3);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setParent(Object obj, View view, int i3) {
            AccessibilityNodeInfoCompatJellyBean.setParent(obj, view, i3);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setSource(Object obj, View view, int i3) {
            AccessibilityNodeInfoCompatJellyBean.setSource(obj, view, i3);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setVisibleToUser(Object obj, boolean z16) {
            AccessibilityNodeInfoCompatJellyBean.setVisibleToUser(obj, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class AccessibilityNodeInfoJellybeanMr2Impl extends AccessibilityNodeInfoJellybeanImpl {
        AccessibilityNodeInfoJellybeanMr2Impl() {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public String getViewIdResourceName(Object obj) {
            return AccessibilityNodeInfoCompatJellybeanMr2.getViewIdResourceName(obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setViewIdResourceName(Object obj, String str) {
            AccessibilityNodeInfoCompatJellybeanMr2.setViewIdResourceName(obj, str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class AccessibilityNodeInfoKitKatImpl extends AccessibilityNodeInfoJellybeanMr2Impl {
        AccessibilityNodeInfoKitKatImpl() {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public Object getCollectionInfo(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.getCollectionInfo(obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getCollectionInfoColumnCount(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.CollectionInfo.getColumnCount(obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getCollectionInfoRowCount(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.CollectionInfo.getRowCount(obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getCollectionItemColumnIndex(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.CollectionItemInfo.getColumnIndex(obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getCollectionItemColumnSpan(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.CollectionItemInfo.getColumnSpan(obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public Object getCollectionItemInfo(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.getCollectionItemInfo(obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getCollectionItemRowIndex(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.CollectionItemInfo.getRowIndex(obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getCollectionItemRowSpan(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.CollectionItemInfo.getRowSpan(obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getLiveRegion(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.getLiveRegion(obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public Object getRangeInfo(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.getRangeInfo(obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isCollectionInfoHierarchical(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.CollectionInfo.isHierarchical(obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isCollectionItemHeading(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.CollectionItemInfo.isHeading(obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public Object obtainCollectionInfo(int i3, int i16, boolean z16, int i17) {
            return AccessibilityNodeInfoCompatKitKat.obtainCollectionInfo(i3, i16, z16, i17);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public Object obtainCollectionItemInfo(int i3, int i16, int i17, int i18, boolean z16, boolean z17) {
            return AccessibilityNodeInfoCompatKitKat.obtainCollectionItemInfo(i3, i16, i17, i18, z16);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setCollectionInfo(Object obj, Object obj2) {
            AccessibilityNodeInfoCompatKitKat.setCollectionInfo(obj, obj2);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setCollectionItemInfo(Object obj, Object obj2) {
            AccessibilityNodeInfoCompatKitKat.setCollectionItemInfo(obj, obj2);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setLiveRegion(Object obj, int i3) {
            AccessibilityNodeInfoCompatKitKat.setLiveRegion(obj, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class AccessibilityNodeInfoStubImpl implements AccessibilityNodeInfoImpl {
        AccessibilityNodeInfoStubImpl() {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void addAction(Object obj, int i3) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void addChild(Object obj, View view) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public List<Object> findAccessibilityNodeInfosByText(Object obj, String str) {
            return Collections.emptyList();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public Object findFocus(Object obj, int i3) {
            return null;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public Object focusSearch(Object obj, int i3) {
            return null;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public List<Object> getActionList(Object obj) {
            return null;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getActions(Object obj) {
            return 0;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public Object getChild(Object obj, int i3) {
            return null;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getChildCount(Object obj) {
            return 0;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public CharSequence getClassName(Object obj) {
            return null;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public Object getCollectionInfo(Object obj) {
            return null;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getCollectionInfoColumnCount(Object obj) {
            return 0;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getCollectionInfoRowCount(Object obj) {
            return 0;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getCollectionItemColumnIndex(Object obj) {
            return 0;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getCollectionItemColumnSpan(Object obj) {
            return 0;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public Object getCollectionItemInfo(Object obj) {
            return null;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getCollectionItemRowIndex(Object obj) {
            return 0;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getCollectionItemRowSpan(Object obj) {
            return 0;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public CharSequence getContentDescription(Object obj) {
            return null;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getLiveRegion(Object obj) {
            return 0;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getMovementGranularities(Object obj) {
            return 0;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public CharSequence getPackageName(Object obj) {
            return null;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public Object getParent(Object obj) {
            return null;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public Object getRangeInfo(Object obj) {
            return null;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public CharSequence getText(Object obj) {
            return null;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public String getViewIdResourceName(Object obj) {
            return null;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getWindowId(Object obj) {
            return 0;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isAccessibilityFocused(Object obj) {
            return false;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isCheckable(Object obj) {
            return false;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isChecked(Object obj) {
            return false;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isClickable(Object obj) {
            return false;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isCollectionInfoHierarchical(Object obj) {
            return false;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isCollectionItemHeading(Object obj) {
            return false;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isCollectionItemSelected(Object obj) {
            return false;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isEnabled(Object obj) {
            return false;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isFocusable(Object obj) {
            return false;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isFocused(Object obj) {
            return false;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isLongClickable(Object obj) {
            return false;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isPassword(Object obj) {
            return false;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isScrollable(Object obj) {
            return false;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isSelected(Object obj) {
            return false;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isVisibleToUser(Object obj) {
            return false;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public Object obtain() {
            return null;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public Object obtainCollectionInfo(int i3, int i16, boolean z16, int i17) {
            return null;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public Object obtainCollectionItemInfo(int i3, int i16, int i17, int i18, boolean z16, boolean z17) {
            return null;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean performAction(Object obj, int i3) {
            return false;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setParent(Object obj, View view) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setSource(Object obj, View view) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void addAction(Object obj, int i3, CharSequence charSequence) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void addChild(Object obj, View view, int i3) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public Object obtain(View view) {
            return null;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean performAction(Object obj, int i3, Bundle bundle) {
            return false;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setParent(Object obj, View view, int i3) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setSource(Object obj, View view, int i3) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public Object obtain(View view, int i3) {
            return null;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public Object obtain(Object obj) {
            return null;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void recycle(Object obj) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void getBoundsInParent(Object obj, Rect rect) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void getBoundsInScreen(Object obj, Rect rect) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setAccessibilityFocused(Object obj, boolean z16) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setBoundsInParent(Object obj, Rect rect) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setBoundsInScreen(Object obj, Rect rect) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setCheckable(Object obj, boolean z16) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setChecked(Object obj, boolean z16) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setClassName(Object obj, CharSequence charSequence) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setClickable(Object obj, boolean z16) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setCollectionInfo(Object obj, Object obj2) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setCollectionItemInfo(Object obj, Object obj2) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setContentDescription(Object obj, CharSequence charSequence) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setEnabled(Object obj, boolean z16) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setFocusable(Object obj, boolean z16) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setFocused(Object obj, boolean z16) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setLiveRegion(Object obj, int i3) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setLongClickable(Object obj, boolean z16) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setMovementGranularities(Object obj, int i3) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setPackageName(Object obj, CharSequence charSequence) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setPassword(Object obj, boolean z16) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setScrollable(Object obj, boolean z16) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setSelected(Object obj, boolean z16) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setText(Object obj, CharSequence charSequence) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setViewIdResourceName(Object obj, String str) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setVisibleToUser(Object obj, boolean z16) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class CollectionInfoCompat {
        public static final int SELECTION_MODE_MULTIPLE = 2;
        public static final int SELECTION_MODE_NONE = 0;
        public static final int SELECTION_MODE_SINGLE = 1;
        final Object mInfo;

        public static CollectionInfoCompat obtain(int i3, int i16, boolean z16, int i17) {
            return new CollectionInfoCompat(AccessibilityNodeInfoCompat.IMPL.obtainCollectionInfo(i3, i16, z16, i17));
        }

        public int getColumnCount() {
            return AccessibilityNodeInfoCompat.IMPL.getCollectionInfoColumnCount(this.mInfo);
        }

        public int getRowCount() {
            return AccessibilityNodeInfoCompat.IMPL.getCollectionInfoRowCount(this.mInfo);
        }

        public boolean isHierarchical() {
            return AccessibilityNodeInfoCompat.IMPL.isCollectionInfoHierarchical(this.mInfo);
        }

        CollectionInfoCompat(Object obj) {
            this.mInfo = obj;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class CollectionItemInfoCompat {
        private final Object mInfo;

        public static CollectionItemInfoCompat obtain(int i3, int i16, int i17, int i18, boolean z16, boolean z17) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfoCompat.IMPL.obtainCollectionItemInfo(i3, i16, i17, i18, z16, z17));
        }

        public int getColumnIndex() {
            return AccessibilityNodeInfoCompat.IMPL.getCollectionItemColumnIndex(this.mInfo);
        }

        public int getColumnSpan() {
            return AccessibilityNodeInfoCompat.IMPL.getCollectionItemColumnSpan(this.mInfo);
        }

        public int getRowIndex() {
            return AccessibilityNodeInfoCompat.IMPL.getCollectionItemRowIndex(this.mInfo);
        }

        public int getRowSpan() {
            return AccessibilityNodeInfoCompat.IMPL.getCollectionItemRowSpan(this.mInfo);
        }

        public boolean isHeading() {
            return AccessibilityNodeInfoCompat.IMPL.isCollectionItemHeading(this.mInfo);
        }

        public boolean isSelected() {
            return AccessibilityNodeInfoCompat.IMPL.isCollectionItemSelected(this.mInfo);
        }

        CollectionItemInfoCompat(Object obj) {
            this.mInfo = obj;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class RangeInfoCompat {
        public static final int RANGE_TYPE_FLOAT = 1;
        public static final int RANGE_TYPE_INT = 0;
        public static final int RANGE_TYPE_PERCENT = 2;
        private final Object mInfo;

        public float getCurrent() {
            return AccessibilityNodeInfoCompatKitKat.RangeInfo.getCurrent(this.mInfo);
        }

        public float getMax() {
            return AccessibilityNodeInfoCompatKitKat.RangeInfo.getMax(this.mInfo);
        }

        public float getMin() {
            return AccessibilityNodeInfoCompatKitKat.RangeInfo.getMin(this.mInfo);
        }

        public int getType() {
            return AccessibilityNodeInfoCompatKitKat.RangeInfo.getType(this.mInfo);
        }

        RangeInfoCompat(Object obj) {
            this.mInfo = obj;
        }
    }

    public AccessibilityNodeInfoCompat(Object obj) {
        this.mInfo = obj;
    }

    private static String getActionSymbolicName(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                switch (i3) {
                    case 4:
                        return "ACTION_SELECT";
                    case 8:
                        return "ACTION_CLEAR_SELECTION";
                    case 16:
                        return "ACTION_CLICK";
                    case 32:
                        return "ACTION_LONG_CLICK";
                    case 64:
                        return "ACTION_ACCESSIBILITY_FOCUS";
                    case 128:
                        return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                    case 256:
                        return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                    case 512:
                        return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                    case 1024:
                        return "ACTION_NEXT_HTML_ELEMENT";
                    case 2048:
                        return "ACTION_PREVIOUS_HTML_ELEMENT";
                    case 4096:
                        return "ACTION_SCROLL_FORWARD";
                    case 8192:
                        return "ACTION_SCROLL_BACKWARD";
                    case 16384:
                        return "ACTION_COPY";
                    case 32768:
                        return "ACTION_PASTE";
                    case 65536:
                        return "ACTION_CUT";
                    case 131072:
                        return "ACTION_SET_SELECTION";
                    default:
                        return "ACTION_UNKNOWN";
                }
            }
            return "ACTION_CLEAR_FOCUS";
        }
        return "ACTION_FOCUS";
    }

    public static AccessibilityNodeInfoCompat obtain(View view) {
        return wrapNonNullInstance(IMPL.obtain(view));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AccessibilityNodeInfoCompat wrapNonNullInstance(Object obj) {
        if (obj != null) {
            return new AccessibilityNodeInfoCompat(obj);
        }
        return null;
    }

    public void addAction(int i3) {
        IMPL.addAction(this.mInfo, i3);
    }

    public void addChild(View view) {
        IMPL.addChild(this.mInfo, view);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) obj;
        Object obj2 = this.mInfo;
        if (obj2 == null) {
            if (accessibilityNodeInfoCompat.mInfo != null) {
                return false;
            }
        } else if (!obj2.equals(accessibilityNodeInfoCompat.mInfo)) {
            return false;
        }
        return true;
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String str) {
        ArrayList arrayList = new ArrayList();
        List<Object> findAccessibilityNodeInfosByText = IMPL.findAccessibilityNodeInfosByText(this.mInfo, str);
        int size = findAccessibilityNodeInfosByText.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.add(new AccessibilityNodeInfoCompat(findAccessibilityNodeInfosByText.get(i3)));
        }
        return arrayList;
    }

    public AccessibilityNodeInfoCompat findFocus(int i3) {
        return wrapNonNullInstance(IMPL.findFocus(this.mInfo, i3));
    }

    public AccessibilityNodeInfoCompat focusSearch(int i3) {
        return wrapNonNullInstance(IMPL.focusSearch(this.mInfo, i3));
    }

    public List<AccessibilityActionCompat> getActionList() {
        ArrayList arrayList = new ArrayList();
        List<Object> actionList = IMPL.getActionList(this.mInfo);
        int size = actionList.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.add(new AccessibilityActionCompat(actionList.get(i3)));
        }
        return arrayList;
    }

    public int getActions() {
        return IMPL.getActions(this.mInfo);
    }

    public void getBoundsInParent(Rect rect) {
        IMPL.getBoundsInParent(this.mInfo, rect);
    }

    public void getBoundsInScreen(Rect rect) {
        IMPL.getBoundsInScreen(this.mInfo, rect);
    }

    public AccessibilityNodeInfoCompat getChild(int i3) {
        return wrapNonNullInstance(IMPL.getChild(this.mInfo, i3));
    }

    public int getChildCount() {
        return IMPL.getChildCount(this.mInfo);
    }

    public CharSequence getClassName() {
        return IMPL.getClassName(this.mInfo);
    }

    public CollectionInfoCompat getCollectionInfo() {
        Object collectionInfo = IMPL.getCollectionInfo(this.mInfo);
        if (collectionInfo == null) {
            return null;
        }
        return new CollectionInfoCompat(collectionInfo);
    }

    public CollectionItemInfoCompat getCollectionItemInfo() {
        Object collectionItemInfo = IMPL.getCollectionItemInfo(this.mInfo);
        if (collectionItemInfo == null) {
            return null;
        }
        return new CollectionItemInfoCompat(collectionItemInfo);
    }

    public CharSequence getContentDescription() {
        return IMPL.getContentDescription(this.mInfo);
    }

    public Object getInfo() {
        return this.mInfo;
    }

    public int getLiveRegion() {
        return IMPL.getLiveRegion(this.mInfo);
    }

    public int getMovementGranularities() {
        return IMPL.getMovementGranularities(this.mInfo);
    }

    public CharSequence getPackageName() {
        return IMPL.getPackageName(this.mInfo);
    }

    public AccessibilityNodeInfoCompat getParent() {
        return wrapNonNullInstance(IMPL.getParent(this.mInfo));
    }

    public RangeInfoCompat getRangeInfo() {
        Object rangeInfo = IMPL.getRangeInfo(this.mInfo);
        if (rangeInfo == null) {
            return null;
        }
        return new RangeInfoCompat(rangeInfo);
    }

    public CharSequence getText() {
        return IMPL.getText(this.mInfo);
    }

    public String getViewIdResourceName() {
        return IMPL.getViewIdResourceName(this.mInfo);
    }

    public int getWindowId() {
        return IMPL.getWindowId(this.mInfo);
    }

    public int hashCode() {
        Object obj = this.mInfo;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public boolean isAccessibilityFocused() {
        return IMPL.isAccessibilityFocused(this.mInfo);
    }

    public boolean isCheckable() {
        return IMPL.isCheckable(this.mInfo);
    }

    public boolean isChecked() {
        return IMPL.isChecked(this.mInfo);
    }

    public boolean isClickable() {
        return IMPL.isClickable(this.mInfo);
    }

    public boolean isEnabled() {
        return IMPL.isEnabled(this.mInfo);
    }

    public boolean isFocusable() {
        return IMPL.isFocusable(this.mInfo);
    }

    public boolean isFocused() {
        return IMPL.isFocused(this.mInfo);
    }

    public boolean isLongClickable() {
        return IMPL.isLongClickable(this.mInfo);
    }

    public boolean isPassword() {
        return IMPL.isPassword(this.mInfo);
    }

    public boolean isScrollable() {
        return IMPL.isScrollable(this.mInfo);
    }

    public boolean isSelected() {
        return IMPL.isSelected(this.mInfo);
    }

    public boolean isVisibleToUser() {
        return IMPL.isVisibleToUser(this.mInfo);
    }

    public boolean performAction(int i3) {
        return IMPL.performAction(this.mInfo, i3);
    }

    public void recycle() {
        IMPL.recycle(this.mInfo);
    }

    public void setAccessibilityFocused(boolean z16) {
        IMPL.setAccessibilityFocused(this.mInfo, z16);
    }

    public void setBoundsInParent(Rect rect) {
        IMPL.setBoundsInParent(this.mInfo, rect);
    }

    public void setBoundsInScreen(Rect rect) {
        IMPL.setBoundsInScreen(this.mInfo, rect);
    }

    public void setCheckable(boolean z16) {
        IMPL.setCheckable(this.mInfo, z16);
    }

    public void setChecked(boolean z16) {
        IMPL.setChecked(this.mInfo, z16);
    }

    public void setClassName(CharSequence charSequence) {
        IMPL.setClassName(this.mInfo, charSequence);
    }

    public void setClickable(boolean z16) {
        IMPL.setClickable(this.mInfo, z16);
    }

    public void setCollectionInfo(Object obj) {
        IMPL.setCollectionInfo(this.mInfo, ((CollectionInfoCompat) obj).mInfo);
    }

    public void setCollectionItemInfo(Object obj) {
        IMPL.setCollectionItemInfo(this.mInfo, ((CollectionItemInfoCompat) obj).mInfo);
    }

    public void setContentDescription(CharSequence charSequence) {
        IMPL.setContentDescription(this.mInfo, charSequence);
    }

    public void setEnabled(boolean z16) {
        IMPL.setEnabled(this.mInfo, z16);
    }

    public void setFocusable(boolean z16) {
        IMPL.setFocusable(this.mInfo, z16);
    }

    public void setFocused(boolean z16) {
        IMPL.setFocused(this.mInfo, z16);
    }

    public void setLiveRegion(int i3) {
        IMPL.setLiveRegion(this.mInfo, i3);
    }

    public void setLongClickable(boolean z16) {
        IMPL.setLongClickable(this.mInfo, z16);
    }

    public void setMovementGranularities(int i3) {
        IMPL.setMovementGranularities(this.mInfo, i3);
    }

    public void setPackageName(CharSequence charSequence) {
        IMPL.setPackageName(this.mInfo, charSequence);
    }

    public void setParent(View view) {
        IMPL.setParent(this.mInfo, view);
    }

    public void setPassword(boolean z16) {
        IMPL.setPassword(this.mInfo, z16);
    }

    public void setScrollable(boolean z16) {
        IMPL.setScrollable(this.mInfo, z16);
    }

    public void setSelected(boolean z16) {
        IMPL.setSelected(this.mInfo, z16);
    }

    public void setSource(View view) {
        IMPL.setSource(this.mInfo, view);
    }

    public void setText(CharSequence charSequence) {
        IMPL.setText(this.mInfo, charSequence);
    }

    public void setViewIdResourceName(String str) {
        IMPL.setViewIdResourceName(this.mInfo, str);
    }

    public void setVisibleToUser(boolean z16) {
        IMPL.setVisibleToUser(this.mInfo, z16);
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(super.toString());
        Rect rect = new Rect();
        getBoundsInParent(rect);
        sb5.append("; boundsInParent: " + rect);
        getBoundsInScreen(rect);
        sb5.append("; boundsInScreen: " + rect);
        sb5.append("; packageName: ");
        sb5.append(getPackageName());
        sb5.append("; className: ");
        sb5.append(getClassName());
        sb5.append("; text: ");
        sb5.append(getText());
        sb5.append("; contentDescription: ");
        sb5.append(getContentDescription());
        sb5.append("; viewId: ");
        sb5.append(getViewIdResourceName());
        sb5.append("; checkable: ");
        sb5.append(isCheckable());
        sb5.append("; checked: ");
        sb5.append(isChecked());
        sb5.append("; focusable: ");
        sb5.append(isFocusable());
        sb5.append("; focused: ");
        sb5.append(isFocused());
        sb5.append("; selected: ");
        sb5.append(isSelected());
        sb5.append("; clickable: ");
        sb5.append(isClickable());
        sb5.append("; longClickable: ");
        sb5.append(isLongClickable());
        sb5.append("; enabled: ");
        sb5.append(isEnabled());
        sb5.append("; password: ");
        sb5.append(isPassword());
        sb5.append("; scrollable: " + isScrollable());
        sb5.append("; [");
        int actions = getActions();
        while (actions != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(actions);
            actions &= ~numberOfTrailingZeros;
            sb5.append(getActionSymbolicName(numberOfTrailingZeros));
            if (actions != 0) {
                sb5.append(", ");
            }
        }
        sb5.append("]");
        return sb5.toString();
    }

    public static AccessibilityNodeInfoCompat obtain(View view, int i3) {
        return wrapNonNullInstance(IMPL.obtain(view, i3));
    }

    public void addChild(View view, int i3) {
        IMPL.addChild(this.mInfo, view, i3);
    }

    public boolean performAction(int i3, Bundle bundle) {
        return IMPL.performAction(this.mInfo, i3, bundle);
    }

    public void setParent(View view, int i3) {
        IMPL.setParent(this.mInfo, view, i3);
    }

    public void setSource(View view, int i3) {
        IMPL.setSource(this.mInfo, view, i3);
    }

    public static AccessibilityNodeInfoCompat obtain() {
        return wrapNonNullInstance(IMPL.obtain());
    }

    public static AccessibilityNodeInfoCompat obtain(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        return wrapNonNullInstance(IMPL.obtain(accessibilityNodeInfoCompat.mInfo));
    }
}
