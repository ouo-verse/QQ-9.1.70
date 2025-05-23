package androidx.core.view.accessibility;

import android.R;
import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.os.BuildCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public class AccessibilityNodeInfoCompat {
    public static final int ACTION_ACCESSIBILITY_FOCUS = 64;
    public static final String ACTION_ARGUMENT_COLUMN_INT = "android.view.accessibility.action.ARGUMENT_COLUMN_INT";
    public static final String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
    public static final String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
    public static final String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
    public static final String ACTION_ARGUMENT_MOVE_WINDOW_X = "ACTION_ARGUMENT_MOVE_WINDOW_X";
    public static final String ACTION_ARGUMENT_MOVE_WINDOW_Y = "ACTION_ARGUMENT_MOVE_WINDOW_Y";

    @SuppressLint({"ActionValue"})
    public static final String ACTION_ARGUMENT_PRESS_AND_HOLD_DURATION_MILLIS_INT = "android.view.accessibility.action.ARGUMENT_PRESS_AND_HOLD_DURATION_MILLIS_INT";
    public static final String ACTION_ARGUMENT_PROGRESS_VALUE = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE";
    public static final String ACTION_ARGUMENT_ROW_INT = "android.view.accessibility.action.ARGUMENT_ROW_INT";
    public static final String ACTION_ARGUMENT_SELECTION_END_INT = "ACTION_ARGUMENT_SELECTION_END_INT";
    public static final String ACTION_ARGUMENT_SELECTION_START_INT = "ACTION_ARGUMENT_SELECTION_START_INT";
    public static final String ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE";
    public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 128;
    public static final int ACTION_CLEAR_FOCUS = 2;
    public static final int ACTION_CLEAR_SELECTION = 8;
    public static final int ACTION_CLICK = 16;
    public static final int ACTION_COLLAPSE = 524288;
    public static final int ACTION_COPY = 16384;
    public static final int ACTION_CUT = 65536;
    public static final int ACTION_DISMISS = 1048576;
    public static final int ACTION_EXPAND = 262144;
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
    private static final int BOOLEAN_PROPERTY_IS_HEADING = 2;
    private static final int BOOLEAN_PROPERTY_IS_SHOWING_HINT = 4;
    private static final int BOOLEAN_PROPERTY_IS_TEXT_ENTRY_KEY = 8;
    private static final String BOOLEAN_PROPERTY_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY";
    private static final int BOOLEAN_PROPERTY_SCREEN_READER_FOCUSABLE = 1;
    public static final int FOCUS_ACCESSIBILITY = 2;
    public static final int FOCUS_INPUT = 1;
    private static final String HINT_TEXT_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY";
    public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
    public static final int MOVEMENT_GRANULARITY_LINE = 4;
    public static final int MOVEMENT_GRANULARITY_PAGE = 16;
    public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
    public static final int MOVEMENT_GRANULARITY_WORD = 2;
    private static final String PANE_TITLE_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY";
    private static final String ROLE_DESCRIPTION_KEY = "AccessibilityNodeInfo.roleDescription";
    private static final String SPANS_ACTION_ID_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY";
    private static final String SPANS_END_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY";
    private static final String SPANS_FLAGS_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY";
    private static final String SPANS_ID_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY";
    private static final String SPANS_START_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY";
    private static final String STATE_DESCRIPTION_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY";
    private static final String TOOLTIP_TEXT_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY";
    private static int sClickableSpanId;
    private final AccessibilityNodeInfo mInfo;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int mParentVirtualDescendantId = -1;
    private int mVirtualDescendantId = -1;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class AccessibilityActionCompat {
        public static final AccessibilityActionCompat ACTION_CONTEXT_CLICK;
        public static final AccessibilityActionCompat ACTION_HIDE_TOOLTIP;

        @NonNull
        public static final AccessibilityActionCompat ACTION_IME_ENTER;
        public static final AccessibilityActionCompat ACTION_MOVE_WINDOW;

        @NonNull
        public static final AccessibilityActionCompat ACTION_PAGE_DOWN;

        @NonNull
        public static final AccessibilityActionCompat ACTION_PAGE_LEFT;

        @NonNull
        public static final AccessibilityActionCompat ACTION_PAGE_RIGHT;

        @NonNull
        public static final AccessibilityActionCompat ACTION_PAGE_UP;

        @NonNull
        public static final AccessibilityActionCompat ACTION_PRESS_AND_HOLD;
        public static final AccessibilityActionCompat ACTION_SCROLL_DOWN;
        public static final AccessibilityActionCompat ACTION_SCROLL_LEFT;
        public static final AccessibilityActionCompat ACTION_SCROLL_RIGHT;
        public static final AccessibilityActionCompat ACTION_SCROLL_TO_POSITION;
        public static final AccessibilityActionCompat ACTION_SCROLL_UP;
        public static final AccessibilityActionCompat ACTION_SET_PROGRESS;
        public static final AccessibilityActionCompat ACTION_SHOW_ON_SCREEN;
        public static final AccessibilityActionCompat ACTION_SHOW_TOOLTIP;
        private static final String TAG = "A11yActionCompat";
        final Object mAction;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected final AccessibilityViewCommand mCommand;
        private final int mId;
        private final Class<? extends AccessibilityViewCommand.CommandArguments> mViewCommandArgumentClass;
        public static final AccessibilityActionCompat ACTION_FOCUS = new AccessibilityActionCompat(1, null);
        public static final AccessibilityActionCompat ACTION_CLEAR_FOCUS = new AccessibilityActionCompat(2, null);
        public static final AccessibilityActionCompat ACTION_SELECT = new AccessibilityActionCompat(4, null);
        public static final AccessibilityActionCompat ACTION_CLEAR_SELECTION = new AccessibilityActionCompat(8, null);
        public static final AccessibilityActionCompat ACTION_CLICK = new AccessibilityActionCompat(16, null);
        public static final AccessibilityActionCompat ACTION_LONG_CLICK = new AccessibilityActionCompat(32, null);
        public static final AccessibilityActionCompat ACTION_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(64, null);
        public static final AccessibilityActionCompat ACTION_CLEAR_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(128, null);
        public static final AccessibilityActionCompat ACTION_NEXT_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(256, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) AccessibilityViewCommand.MoveAtGranularityArguments.class);
        public static final AccessibilityActionCompat ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(512, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) AccessibilityViewCommand.MoveAtGranularityArguments.class);
        public static final AccessibilityActionCompat ACTION_NEXT_HTML_ELEMENT = new AccessibilityActionCompat(1024, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) AccessibilityViewCommand.MoveHtmlArguments.class);
        public static final AccessibilityActionCompat ACTION_PREVIOUS_HTML_ELEMENT = new AccessibilityActionCompat(2048, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) AccessibilityViewCommand.MoveHtmlArguments.class);
        public static final AccessibilityActionCompat ACTION_SCROLL_FORWARD = new AccessibilityActionCompat(4096, null);
        public static final AccessibilityActionCompat ACTION_SCROLL_BACKWARD = new AccessibilityActionCompat(8192, null);
        public static final AccessibilityActionCompat ACTION_COPY = new AccessibilityActionCompat(16384, null);
        public static final AccessibilityActionCompat ACTION_PASTE = new AccessibilityActionCompat(32768, null);
        public static final AccessibilityActionCompat ACTION_CUT = new AccessibilityActionCompat(65536, null);
        public static final AccessibilityActionCompat ACTION_SET_SELECTION = new AccessibilityActionCompat(131072, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) AccessibilityViewCommand.SetSelectionArguments.class);
        public static final AccessibilityActionCompat ACTION_EXPAND = new AccessibilityActionCompat(262144, null);
        public static final AccessibilityActionCompat ACTION_COLLAPSE = new AccessibilityActionCompat(524288, null);
        public static final AccessibilityActionCompat ACTION_DISMISS = new AccessibilityActionCompat(1048576, null);
        public static final AccessibilityActionCompat ACTION_SET_TEXT = new AccessibilityActionCompat(2097152, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) AccessibilityViewCommand.SetTextArguments.class);

        static {
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction2;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction3;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction4;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction5;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction6;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction7;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction8;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction9;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction10;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction11;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction12;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction13;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction14;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction15;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction16;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction17;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction18;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction19 = null;
            int i3 = Build.VERSION.SDK_INT;
            ACTION_SHOW_ON_SCREEN = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null, null, null);
            ACTION_SCROLL_TO_POSITION = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, null, null, AccessibilityViewCommand.ScrollToPositionArguments.class);
            ACTION_SCROLL_UP = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null, null, null);
            ACTION_SCROLL_LEFT = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null, null, null);
            ACTION_SCROLL_DOWN = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null, null, null);
            ACTION_SCROLL_RIGHT = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null, null, null);
            if (i3 >= 29) {
                accessibilityAction18 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP;
                accessibilityAction = accessibilityAction18;
            } else {
                accessibilityAction = null;
            }
            ACTION_PAGE_UP = new AccessibilityActionCompat(accessibilityAction, R.id.accessibilityActionPageUp, null, null, null);
            if (i3 >= 29) {
                accessibilityAction17 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN;
                accessibilityAction2 = accessibilityAction17;
            } else {
                accessibilityAction2 = null;
            }
            ACTION_PAGE_DOWN = new AccessibilityActionCompat(accessibilityAction2, R.id.accessibilityActionPageDown, null, null, null);
            if (i3 >= 29) {
                accessibilityAction16 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT;
                accessibilityAction3 = accessibilityAction16;
            } else {
                accessibilityAction3 = null;
            }
            ACTION_PAGE_LEFT = new AccessibilityActionCompat(accessibilityAction3, R.id.accessibilityActionPageLeft, null, null, null);
            if (i3 >= 29) {
                accessibilityAction15 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT;
                accessibilityAction4 = accessibilityAction15;
            } else {
                accessibilityAction4 = null;
            }
            ACTION_PAGE_RIGHT = new AccessibilityActionCompat(accessibilityAction4, R.id.accessibilityActionPageRight, null, null, null);
            ACTION_CONTEXT_CLICK = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null, null, null);
            if (i3 >= 24) {
                accessibilityAction14 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
                accessibilityAction5 = accessibilityAction14;
            } else {
                accessibilityAction5 = null;
            }
            ACTION_SET_PROGRESS = new AccessibilityActionCompat(accessibilityAction5, R.id.accessibilityActionSetProgress, null, null, AccessibilityViewCommand.SetProgressArguments.class);
            if (i3 >= 26) {
                accessibilityAction13 = AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW;
                accessibilityAction6 = accessibilityAction13;
            } else {
                accessibilityAction6 = null;
            }
            ACTION_MOVE_WINDOW = new AccessibilityActionCompat(accessibilityAction6, R.id.accessibilityActionMoveWindow, null, null, AccessibilityViewCommand.MoveWindowArguments.class);
            if (i3 >= 28) {
                accessibilityAction12 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;
                accessibilityAction7 = accessibilityAction12;
            } else {
                accessibilityAction7 = null;
            }
            ACTION_SHOW_TOOLTIP = new AccessibilityActionCompat(accessibilityAction7, R.id.accessibilityActionShowTooltip, null, null, null);
            if (i3 >= 28) {
                accessibilityAction11 = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
                accessibilityAction8 = accessibilityAction11;
            } else {
                accessibilityAction8 = null;
            }
            ACTION_HIDE_TOOLTIP = new AccessibilityActionCompat(accessibilityAction8, R.id.accessibilityActionHideTooltip, null, null, null);
            if (i3 >= 30) {
                accessibilityAction10 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD;
                accessibilityAction9 = accessibilityAction10;
            } else {
                accessibilityAction9 = null;
            }
            ACTION_PRESS_AND_HOLD = new AccessibilityActionCompat(accessibilityAction9, R.id.accessibilityActionPressAndHold, null, null, null);
            if (i3 >= 30) {
                accessibilityAction19 = AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER;
            }
            ACTION_IME_ENTER = new AccessibilityActionCompat(accessibilityAction19, R.id.accessibilityActionImeEnter, null, null, null);
        }

        public AccessibilityActionCompat(int i3, CharSequence charSequence) {
            this(null, i3, charSequence, null, null);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public AccessibilityActionCompat createReplacementAction(CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
            return new AccessibilityActionCompat(null, this.mId, charSequence, accessibilityViewCommand, this.mViewCommandArgumentClass);
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == null || !(obj instanceof AccessibilityActionCompat)) {
                return false;
            }
            AccessibilityActionCompat accessibilityActionCompat = (AccessibilityActionCompat) obj;
            Object obj2 = this.mAction;
            if (obj2 == null) {
                if (accessibilityActionCompat.mAction != null) {
                    return false;
                }
                return true;
            }
            if (!obj2.equals(accessibilityActionCompat.mAction)) {
                return false;
            }
            return true;
        }

        public int getId() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.mAction).getId();
        }

        public CharSequence getLabel() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.mAction).getLabel();
        }

        public int hashCode() {
            Object obj = this.mAction;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean perform(View view, Bundle bundle) {
            String name;
            if (this.mCommand == null) {
                return false;
            }
            Class<? extends AccessibilityViewCommand.CommandArguments> cls = this.mViewCommandArgumentClass;
            AccessibilityViewCommand.CommandArguments commandArguments = null;
            if (cls != null) {
                try {
                    AccessibilityViewCommand.CommandArguments newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    try {
                        newInstance.setBundle(bundle);
                        commandArguments = newInstance;
                    } catch (Exception e16) {
                        e = e16;
                        commandArguments = newInstance;
                        Class<? extends AccessibilityViewCommand.CommandArguments> cls2 = this.mViewCommandArgumentClass;
                        if (cls2 == null) {
                            name = "null";
                        } else {
                            name = cls2.getName();
                        }
                        Log.e(TAG, "Failed to execute command with argument class ViewCommandArgument: " + name, e);
                        return this.mCommand.perform(view, commandArguments);
                    }
                } catch (Exception e17) {
                    e = e17;
                }
            }
            return this.mCommand.perform(view, commandArguments);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public AccessibilityActionCompat(int i3, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
            this(null, i3, charSequence, accessibilityViewCommand, null);
        }

        AccessibilityActionCompat(Object obj) {
            this(obj, 0, null, null, null);
        }

        AccessibilityActionCompat(int i3, CharSequence charSequence, Class<? extends AccessibilityViewCommand.CommandArguments> cls) {
            this(null, i3, charSequence, null, cls);
        }

        AccessibilityActionCompat(Object obj, int i3, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand, Class<? extends AccessibilityViewCommand.CommandArguments> cls) {
            this.mId = i3;
            this.mCommand = accessibilityViewCommand;
            if (obj == null) {
                this.mAction = new AccessibilityNodeInfo.AccessibilityAction(i3, charSequence);
            } else {
                this.mAction = obj;
            }
            this.mViewCommandArgumentClass = cls;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class CollectionInfoCompat {
        public static final int SELECTION_MODE_MULTIPLE = 2;
        public static final int SELECTION_MODE_NONE = 0;
        public static final int SELECTION_MODE_SINGLE = 1;
        final Object mInfo;

        CollectionInfoCompat(Object obj) {
            this.mInfo = obj;
        }

        public static CollectionInfoCompat obtain(int i3, int i16, boolean z16, int i17) {
            return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(i3, i16, z16, i17));
        }

        public int getColumnCount() {
            return ((AccessibilityNodeInfo.CollectionInfo) this.mInfo).getColumnCount();
        }

        public int getRowCount() {
            return ((AccessibilityNodeInfo.CollectionInfo) this.mInfo).getRowCount();
        }

        public int getSelectionMode() {
            return ((AccessibilityNodeInfo.CollectionInfo) this.mInfo).getSelectionMode();
        }

        public boolean isHierarchical() {
            return ((AccessibilityNodeInfo.CollectionInfo) this.mInfo).isHierarchical();
        }

        public static CollectionInfoCompat obtain(int i3, int i16, boolean z16) {
            return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(i3, i16, z16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class CollectionItemInfoCompat {
        final Object mInfo;

        CollectionItemInfoCompat(Object obj) {
            this.mInfo = obj;
        }

        public static CollectionItemInfoCompat obtain(int i3, int i16, int i17, int i18, boolean z16, boolean z17) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(i3, i16, i17, i18, z16, z17));
        }

        public int getColumnIndex() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).getColumnIndex();
        }

        public int getColumnSpan() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).getColumnSpan();
        }

        public int getRowIndex() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).getRowIndex();
        }

        public int getRowSpan() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).getRowSpan();
        }

        @Deprecated
        public boolean isHeading() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).isHeading();
        }

        public boolean isSelected() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).isSelected();
        }

        public static CollectionItemInfoCompat obtain(int i3, int i16, int i17, int i18, boolean z16) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(i3, i16, i17, i18, z16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class RangeInfoCompat {
        public static final int RANGE_TYPE_FLOAT = 1;
        public static final int RANGE_TYPE_INT = 0;
        public static final int RANGE_TYPE_PERCENT = 2;
        final Object mInfo;

        RangeInfoCompat(Object obj) {
            this.mInfo = obj;
        }

        public static RangeInfoCompat obtain(int i3, float f16, float f17, float f18) {
            return new RangeInfoCompat(AccessibilityNodeInfo.RangeInfo.obtain(i3, f16, f17, f18));
        }

        public float getCurrent() {
            return ((AccessibilityNodeInfo.RangeInfo) this.mInfo).getCurrent();
        }

        public float getMax() {
            return ((AccessibilityNodeInfo.RangeInfo) this.mInfo).getMax();
        }

        public float getMin() {
            return ((AccessibilityNodeInfo.RangeInfo) this.mInfo).getMin();
        }

        public int getType() {
            return ((AccessibilityNodeInfo.RangeInfo) this.mInfo).getType();
        }
    }

    @Deprecated
    public AccessibilityNodeInfoCompat(Object obj) {
        this.mInfo = (AccessibilityNodeInfo) obj;
    }

    private void addSpanLocationToExtras(ClickableSpan clickableSpan, Spanned spanned, int i3) {
        extrasIntList(SPANS_START_KEY).add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        extrasIntList(SPANS_END_KEY).add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        extrasIntList(SPANS_FLAGS_KEY).add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        extrasIntList(SPANS_ID_KEY).add(Integer.valueOf(i3));
    }

    private void clearExtrasSpans() {
        this.mInfo.getExtras().remove(SPANS_START_KEY);
        this.mInfo.getExtras().remove(SPANS_END_KEY);
        this.mInfo.getExtras().remove(SPANS_FLAGS_KEY);
        this.mInfo.getExtras().remove(SPANS_ID_KEY);
    }

    private List<Integer> extrasIntList(String str) {
        ArrayList<Integer> integerArrayList = this.mInfo.getExtras().getIntegerArrayList(str);
        if (integerArrayList == null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            this.mInfo.getExtras().putIntegerArrayList(str, arrayList);
            return arrayList;
        }
        return integerArrayList;
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
                    case 262144:
                        return "ACTION_EXPAND";
                    case 524288:
                        return "ACTION_COLLAPSE";
                    case 2097152:
                        return "ACTION_SET_TEXT";
                    case R.id.accessibilityActionMoveWindow:
                        return "ACTION_MOVE_WINDOW";
                    case R.id.accessibilityActionImeEnter:
                        return "ACTION_IME_ENTER";
                    default:
                        switch (i3) {
                            case R.id.accessibilityActionShowOnScreen:
                                return "ACTION_SHOW_ON_SCREEN";
                            case R.id.accessibilityActionScrollToPosition:
                                return "ACTION_SCROLL_TO_POSITION";
                            case R.id.accessibilityActionScrollUp:
                                return "ACTION_SCROLL_UP";
                            case R.id.accessibilityActionScrollLeft:
                                return "ACTION_SCROLL_LEFT";
                            case R.id.accessibilityActionScrollDown:
                                return "ACTION_SCROLL_DOWN";
                            case R.id.accessibilityActionScrollRight:
                                return "ACTION_SCROLL_RIGHT";
                            case R.id.accessibilityActionContextClick:
                                return "ACTION_CONTEXT_CLICK";
                            case R.id.accessibilityActionSetProgress:
                                return "ACTION_SET_PROGRESS";
                            default:
                                switch (i3) {
                                    case R.id.accessibilityActionShowTooltip:
                                        return "ACTION_SHOW_TOOLTIP";
                                    case R.id.accessibilityActionHideTooltip:
                                        return "ACTION_HIDE_TOOLTIP";
                                    case R.id.accessibilityActionPageUp:
                                        return "ACTION_PAGE_UP";
                                    case R.id.accessibilityActionPageDown:
                                        return "ACTION_PAGE_DOWN";
                                    case R.id.accessibilityActionPageLeft:
                                        return "ACTION_PAGE_LEFT";
                                    case R.id.accessibilityActionPageRight:
                                        return "ACTION_PAGE_RIGHT";
                                    case R.id.accessibilityActionPressAndHold:
                                        return "ACTION_PRESS_AND_HOLD";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
            }
            return "ACTION_CLEAR_FOCUS";
        }
        return "ACTION_FOCUS";
    }

    private boolean getBooleanProperty(int i3) {
        Bundle extras = getExtras();
        if (extras == null || (extras.getInt(BOOLEAN_PROPERTY_KEY, 0) & i3) != i3) {
            return false;
        }
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static ClickableSpan[] getClickableSpans(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    private SparseArray<WeakReference<ClickableSpan>> getOrCreateSpansFromViewTags(View view) {
        SparseArray<WeakReference<ClickableSpan>> spansFromViewTags = getSpansFromViewTags(view);
        if (spansFromViewTags == null) {
            SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
            view.setTag(com.tencent.mobileqq.R.id.f9212571, sparseArray);
            return sparseArray;
        }
        return spansFromViewTags;
    }

    private SparseArray<WeakReference<ClickableSpan>> getSpansFromViewTags(View view) {
        return (SparseArray) view.getTag(com.tencent.mobileqq.R.id.f9212571);
    }

    private boolean hasSpans() {
        return !extrasIntList(SPANS_START_KEY).isEmpty();
    }

    private int idForClickableSpan(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                if (clickableSpan.equals(sparseArray.valueAt(i3).get())) {
                    return sparseArray.keyAt(i3);
                }
            }
        }
        int i16 = sClickableSpanId;
        sClickableSpanId = i16 + 1;
        return i16;
    }

    public static AccessibilityNodeInfoCompat obtain(View view) {
        return wrap(AccessibilityNodeInfo.obtain(view));
    }

    private void removeCollectedSpans(View view) {
        SparseArray<WeakReference<ClickableSpan>> spansFromViewTags = getSpansFromViewTags(view);
        if (spansFromViewTags != null) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < spansFromViewTags.size(); i3++) {
                if (spansFromViewTags.valueAt(i3).get() == null) {
                    arrayList.add(Integer.valueOf(i3));
                }
            }
            for (int i16 = 0; i16 < arrayList.size(); i16++) {
                spansFromViewTags.remove(((Integer) arrayList.get(i16)).intValue());
            }
        }
    }

    private void setBooleanProperty(int i3, boolean z16) {
        Bundle extras = getExtras();
        if (extras != null) {
            int i16 = extras.getInt(BOOLEAN_PROPERTY_KEY, 0) & (~i3);
            if (!z16) {
                i3 = 0;
            }
            extras.putInt(BOOLEAN_PROPERTY_KEY, i3 | i16);
        }
    }

    public static AccessibilityNodeInfoCompat wrap(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        return new AccessibilityNodeInfoCompat(accessibilityNodeInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AccessibilityNodeInfoCompat wrapNonNullInstance(Object obj) {
        if (obj != null) {
            return new AccessibilityNodeInfoCompat(obj);
        }
        return null;
    }

    public void addAction(int i3) {
        this.mInfo.addAction(i3);
    }

    public void addChild(View view) {
        this.mInfo.addChild(view);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void addSpansToExtras(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT < 26) {
            clearExtrasSpans();
            removeCollectedSpans(view);
            ClickableSpan[] clickableSpans = getClickableSpans(charSequence);
            if (clickableSpans != null && clickableSpans.length > 0) {
                getExtras().putInt(SPANS_ACTION_ID_KEY, com.tencent.mobileqq.R.id.s6t);
                SparseArray<WeakReference<ClickableSpan>> orCreateSpansFromViewTags = getOrCreateSpansFromViewTags(view);
                for (int i3 = 0; i3 < clickableSpans.length; i3++) {
                    int idForClickableSpan = idForClickableSpan(clickableSpans[i3], orCreateSpansFromViewTags);
                    orCreateSpansFromViewTags.put(idForClickableSpan, new WeakReference<>(clickableSpans[i3]));
                    addSpanLocationToExtras(clickableSpans[i3], (Spanned) charSequence, idForClickableSpan);
                }
            }
        }
    }

    public boolean canOpenPopup() {
        return this.mInfo.canOpenPopup();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AccessibilityNodeInfoCompat)) {
            return false;
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
        if (accessibilityNodeInfo == null) {
            if (accessibilityNodeInfoCompat.mInfo != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(accessibilityNodeInfoCompat.mInfo)) {
            return false;
        }
        if (this.mVirtualDescendantId == accessibilityNodeInfoCompat.mVirtualDescendantId && this.mParentVirtualDescendantId == accessibilityNodeInfoCompat.mParentVirtualDescendantId) {
            return true;
        }
        return false;
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String str) {
        ArrayList arrayList = new ArrayList();
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText = this.mInfo.findAccessibilityNodeInfosByText(str);
        int size = findAccessibilityNodeInfosByText.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.add(wrap(findAccessibilityNodeInfosByText.get(i3)));
        }
        return arrayList;
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByViewId(String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId = this.mInfo.findAccessibilityNodeInfosByViewId(str);
        ArrayList arrayList = new ArrayList();
        Iterator<AccessibilityNodeInfo> it = findAccessibilityNodeInfosByViewId.iterator();
        while (it.hasNext()) {
            arrayList.add(wrap(it.next()));
        }
        return arrayList;
    }

    public AccessibilityNodeInfoCompat findFocus(int i3) {
        return wrapNonNullInstance(this.mInfo.findFocus(i3));
    }

    public AccessibilityNodeInfoCompat focusSearch(int i3) {
        return wrapNonNullInstance(this.mInfo.focusSearch(i3));
    }

    public List<AccessibilityActionCompat> getActionList() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.mInfo.getActionList();
        if (actionList != null) {
            ArrayList arrayList = new ArrayList();
            int size = actionList.size();
            for (int i3 = 0; i3 < size; i3++) {
                arrayList.add(new AccessibilityActionCompat(actionList.get(i3)));
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public int getActions() {
        return this.mInfo.getActions();
    }

    @Deprecated
    public void getBoundsInParent(Rect rect) {
        this.mInfo.getBoundsInParent(rect);
    }

    public void getBoundsInScreen(Rect rect) {
        this.mInfo.getBoundsInScreen(rect);
    }

    public AccessibilityNodeInfoCompat getChild(int i3) {
        return wrapNonNullInstance(this.mInfo.getChild(i3));
    }

    public int getChildCount() {
        return this.mInfo.getChildCount();
    }

    public CharSequence getClassName() {
        return this.mInfo.getClassName();
    }

    public CollectionInfoCompat getCollectionInfo() {
        AccessibilityNodeInfo.CollectionInfo collectionInfo = this.mInfo.getCollectionInfo();
        if (collectionInfo != null) {
            return new CollectionInfoCompat(collectionInfo);
        }
        return null;
    }

    public CollectionItemInfoCompat getCollectionItemInfo() {
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo = this.mInfo.getCollectionItemInfo();
        if (collectionItemInfo != null) {
            return new CollectionItemInfoCompat(collectionItemInfo);
        }
        return null;
    }

    public CharSequence getContentDescription() {
        return this.mInfo.getContentDescription();
    }

    public int getDrawingOrder() {
        int drawingOrder;
        if (Build.VERSION.SDK_INT >= 24) {
            drawingOrder = this.mInfo.getDrawingOrder();
            return drawingOrder;
        }
        return 0;
    }

    public CharSequence getError() {
        return this.mInfo.getError();
    }

    public Bundle getExtras() {
        return this.mInfo.getExtras();
    }

    @Nullable
    public CharSequence getHintText() {
        CharSequence hintText;
        if (Build.VERSION.SDK_INT >= 26) {
            hintText = this.mInfo.getHintText();
            return hintText;
        }
        return this.mInfo.getExtras().getCharSequence(HINT_TEXT_KEY);
    }

    @Deprecated
    public Object getInfo() {
        return this.mInfo;
    }

    public int getInputType() {
        return this.mInfo.getInputType();
    }

    public AccessibilityNodeInfoCompat getLabelFor() {
        return wrapNonNullInstance(this.mInfo.getLabelFor());
    }

    public AccessibilityNodeInfoCompat getLabeledBy() {
        return wrapNonNullInstance(this.mInfo.getLabeledBy());
    }

    public int getLiveRegion() {
        return this.mInfo.getLiveRegion();
    }

    public int getMaxTextLength() {
        return this.mInfo.getMaxTextLength();
    }

    public int getMovementGranularities() {
        return this.mInfo.getMovementGranularities();
    }

    public CharSequence getPackageName() {
        return this.mInfo.getPackageName();
    }

    @Nullable
    public CharSequence getPaneTitle() {
        CharSequence paneTitle;
        if (Build.VERSION.SDK_INT >= 28) {
            paneTitle = this.mInfo.getPaneTitle();
            return paneTitle;
        }
        return this.mInfo.getExtras().getCharSequence(PANE_TITLE_KEY);
    }

    public AccessibilityNodeInfoCompat getParent() {
        return wrapNonNullInstance(this.mInfo.getParent());
    }

    public RangeInfoCompat getRangeInfo() {
        AccessibilityNodeInfo.RangeInfo rangeInfo = this.mInfo.getRangeInfo();
        if (rangeInfo != null) {
            return new RangeInfoCompat(rangeInfo);
        }
        return null;
    }

    @Nullable
    public CharSequence getRoleDescription() {
        return this.mInfo.getExtras().getCharSequence(ROLE_DESCRIPTION_KEY);
    }

    @Nullable
    public CharSequence getStateDescription() {
        CharSequence stateDescription;
        if (BuildCompat.isAtLeastR()) {
            stateDescription = this.mInfo.getStateDescription();
            return stateDescription;
        }
        return this.mInfo.getExtras().getCharSequence(STATE_DESCRIPTION_KEY);
    }

    public CharSequence getText() {
        if (hasSpans()) {
            List<Integer> extrasIntList = extrasIntList(SPANS_START_KEY);
            List<Integer> extrasIntList2 = extrasIntList(SPANS_END_KEY);
            List<Integer> extrasIntList3 = extrasIntList(SPANS_FLAGS_KEY);
            List<Integer> extrasIntList4 = extrasIntList(SPANS_ID_KEY);
            SpannableString spannableString = new SpannableString(TextUtils.substring(this.mInfo.getText(), 0, this.mInfo.getText().length()));
            for (int i3 = 0; i3 < extrasIntList.size(); i3++) {
                spannableString.setSpan(new AccessibilityClickableSpanCompat(extrasIntList4.get(i3).intValue(), this, getExtras().getInt(SPANS_ACTION_ID_KEY)), extrasIntList.get(i3).intValue(), extrasIntList2.get(i3).intValue(), extrasIntList3.get(i3).intValue());
            }
            return spannableString;
        }
        return this.mInfo.getText();
    }

    public int getTextSelectionEnd() {
        return this.mInfo.getTextSelectionEnd();
    }

    public int getTextSelectionStart() {
        return this.mInfo.getTextSelectionStart();
    }

    @Nullable
    public CharSequence getTooltipText() {
        CharSequence tooltipText;
        if (Build.VERSION.SDK_INT >= 28) {
            tooltipText = this.mInfo.getTooltipText();
            return tooltipText;
        }
        return this.mInfo.getExtras().getCharSequence(TOOLTIP_TEXT_KEY);
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0006, code lost:
    
        r0 = r2.mInfo.getTouchDelegateInfo();
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TouchDelegateInfoCompat getTouchDelegateInfo() {
        AccessibilityNodeInfo.TouchDelegateInfo touchDelegateInfo;
        if (Build.VERSION.SDK_INT >= 29 && touchDelegateInfo != null) {
            return new TouchDelegateInfoCompat(touchDelegateInfo);
        }
        return null;
    }

    public AccessibilityNodeInfoCompat getTraversalAfter() {
        return wrapNonNullInstance(this.mInfo.getTraversalAfter());
    }

    public AccessibilityNodeInfoCompat getTraversalBefore() {
        return wrapNonNullInstance(this.mInfo.getTraversalBefore());
    }

    public String getViewIdResourceName() {
        return this.mInfo.getViewIdResourceName();
    }

    public AccessibilityWindowInfoCompat getWindow() {
        return AccessibilityWindowInfoCompat.wrapNonNullInstance(this.mInfo.getWindow());
    }

    public int getWindowId() {
        return this.mInfo.getWindowId();
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public boolean isAccessibilityFocused() {
        return this.mInfo.isAccessibilityFocused();
    }

    public boolean isCheckable() {
        return this.mInfo.isCheckable();
    }

    public boolean isChecked() {
        return this.mInfo.isChecked();
    }

    public boolean isClickable() {
        return this.mInfo.isClickable();
    }

    public boolean isContentInvalid() {
        return this.mInfo.isContentInvalid();
    }

    public boolean isContextClickable() {
        return this.mInfo.isContextClickable();
    }

    public boolean isDismissable() {
        return this.mInfo.isDismissable();
    }

    public boolean isEditable() {
        return this.mInfo.isEditable();
    }

    public boolean isEnabled() {
        return this.mInfo.isEnabled();
    }

    public boolean isFocusable() {
        return this.mInfo.isFocusable();
    }

    public boolean isFocused() {
        return this.mInfo.isFocused();
    }

    public boolean isHeading() {
        boolean isHeading;
        if (Build.VERSION.SDK_INT >= 28) {
            isHeading = this.mInfo.isHeading();
            return isHeading;
        }
        if (getBooleanProperty(2)) {
            return true;
        }
        CollectionItemInfoCompat collectionItemInfo = getCollectionItemInfo();
        if (collectionItemInfo != null && collectionItemInfo.isHeading()) {
            return true;
        }
        return false;
    }

    public boolean isImportantForAccessibility() {
        boolean isImportantForAccessibility;
        if (Build.VERSION.SDK_INT >= 24) {
            isImportantForAccessibility = this.mInfo.isImportantForAccessibility();
            return isImportantForAccessibility;
        }
        return true;
    }

    public boolean isLongClickable() {
        return this.mInfo.isLongClickable();
    }

    public boolean isMultiLine() {
        return this.mInfo.isMultiLine();
    }

    public boolean isPassword() {
        return this.mInfo.isPassword();
    }

    public boolean isScreenReaderFocusable() {
        boolean isScreenReaderFocusable;
        if (Build.VERSION.SDK_INT >= 28) {
            isScreenReaderFocusable = this.mInfo.isScreenReaderFocusable();
            return isScreenReaderFocusable;
        }
        return getBooleanProperty(1);
    }

    public boolean isScrollable() {
        return this.mInfo.isScrollable();
    }

    public boolean isSelected() {
        return this.mInfo.isSelected();
    }

    public boolean isShowingHintText() {
        boolean isShowingHintText;
        if (Build.VERSION.SDK_INT >= 26) {
            isShowingHintText = this.mInfo.isShowingHintText();
            return isShowingHintText;
        }
        return getBooleanProperty(4);
    }

    public boolean isTextEntryKey() {
        boolean isTextEntryKey;
        if (Build.VERSION.SDK_INT >= 29) {
            isTextEntryKey = this.mInfo.isTextEntryKey();
            return isTextEntryKey;
        }
        return getBooleanProperty(8);
    }

    public boolean isVisibleToUser() {
        return this.mInfo.isVisibleToUser();
    }

    public boolean performAction(int i3) {
        return this.mInfo.performAction(i3);
    }

    public void recycle() {
        this.mInfo.recycle();
    }

    public boolean refresh() {
        return this.mInfo.refresh();
    }

    public boolean removeAction(AccessibilityActionCompat accessibilityActionCompat) {
        return this.mInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) accessibilityActionCompat.mAction);
    }

    public boolean removeChild(View view) {
        return this.mInfo.removeChild(view);
    }

    public void setAccessibilityFocused(boolean z16) {
        this.mInfo.setAccessibilityFocused(z16);
    }

    @Deprecated
    public void setBoundsInParent(Rect rect) {
        this.mInfo.setBoundsInParent(rect);
    }

    public void setBoundsInScreen(Rect rect) {
        this.mInfo.setBoundsInScreen(rect);
    }

    public void setCanOpenPopup(boolean z16) {
        this.mInfo.setCanOpenPopup(z16);
    }

    public void setCheckable(boolean z16) {
        this.mInfo.setCheckable(z16);
    }

    public void setChecked(boolean z16) {
        this.mInfo.setChecked(z16);
    }

    public void setClassName(CharSequence charSequence) {
        this.mInfo.setClassName(charSequence);
    }

    public void setClickable(boolean z16) {
        this.mInfo.setClickable(z16);
    }

    public void setCollectionInfo(Object obj) {
        AccessibilityNodeInfo.CollectionInfo collectionInfo;
        AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
        if (obj == null) {
            collectionInfo = null;
        } else {
            collectionInfo = (AccessibilityNodeInfo.CollectionInfo) ((CollectionInfoCompat) obj).mInfo;
        }
        accessibilityNodeInfo.setCollectionInfo(collectionInfo);
    }

    public void setCollectionItemInfo(Object obj) {
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo;
        AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
        if (obj == null) {
            collectionItemInfo = null;
        } else {
            collectionItemInfo = (AccessibilityNodeInfo.CollectionItemInfo) ((CollectionItemInfoCompat) obj).mInfo;
        }
        accessibilityNodeInfo.setCollectionItemInfo(collectionItemInfo);
    }

    public void setContentDescription(CharSequence charSequence) {
        this.mInfo.setContentDescription(charSequence);
    }

    public void setContentInvalid(boolean z16) {
        this.mInfo.setContentInvalid(z16);
    }

    public void setContextClickable(boolean z16) {
        this.mInfo.setContextClickable(z16);
    }

    public void setDismissable(boolean z16) {
        this.mInfo.setDismissable(z16);
    }

    public void setDrawingOrder(int i3) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.mInfo.setDrawingOrder(i3);
        }
    }

    public void setEditable(boolean z16) {
        this.mInfo.setEditable(z16);
    }

    public void setEnabled(boolean z16) {
        this.mInfo.setEnabled(z16);
    }

    public void setError(CharSequence charSequence) {
        this.mInfo.setError(charSequence);
    }

    public void setFocusable(boolean z16) {
        this.mInfo.setFocusable(z16);
    }

    public void setFocused(boolean z16) {
        this.mInfo.setFocused(z16);
    }

    public void setHeading(boolean z16) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.mInfo.setHeading(z16);
        } else {
            setBooleanProperty(2, z16);
        }
    }

    public void setHintText(@Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mInfo.setHintText(charSequence);
        } else {
            this.mInfo.getExtras().putCharSequence(HINT_TEXT_KEY, charSequence);
        }
    }

    public void setImportantForAccessibility(boolean z16) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.mInfo.setImportantForAccessibility(z16);
        }
    }

    public void setInputType(int i3) {
        this.mInfo.setInputType(i3);
    }

    public void setLabelFor(View view) {
        this.mInfo.setLabelFor(view);
    }

    public void setLabeledBy(View view) {
        this.mInfo.setLabeledBy(view);
    }

    public void setLiveRegion(int i3) {
        this.mInfo.setLiveRegion(i3);
    }

    public void setLongClickable(boolean z16) {
        this.mInfo.setLongClickable(z16);
    }

    public void setMaxTextLength(int i3) {
        this.mInfo.setMaxTextLength(i3);
    }

    public void setMovementGranularities(int i3) {
        this.mInfo.setMovementGranularities(i3);
    }

    public void setMultiLine(boolean z16) {
        this.mInfo.setMultiLine(z16);
    }

    public void setPackageName(CharSequence charSequence) {
        this.mInfo.setPackageName(charSequence);
    }

    public void setPaneTitle(@Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.mInfo.setPaneTitle(charSequence);
        } else {
            this.mInfo.getExtras().putCharSequence(PANE_TITLE_KEY, charSequence);
        }
    }

    public void setParent(View view) {
        this.mParentVirtualDescendantId = -1;
        this.mInfo.setParent(view);
    }

    public void setPassword(boolean z16) {
        this.mInfo.setPassword(z16);
    }

    public void setRangeInfo(RangeInfoCompat rangeInfoCompat) {
        this.mInfo.setRangeInfo((AccessibilityNodeInfo.RangeInfo) rangeInfoCompat.mInfo);
    }

    public void setRoleDescription(@Nullable CharSequence charSequence) {
        this.mInfo.getExtras().putCharSequence(ROLE_DESCRIPTION_KEY, charSequence);
    }

    public void setScreenReaderFocusable(boolean z16) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.mInfo.setScreenReaderFocusable(z16);
        } else {
            setBooleanProperty(1, z16);
        }
    }

    public void setScrollable(boolean z16) {
        this.mInfo.setScrollable(z16);
    }

    public void setSelected(boolean z16) {
        this.mInfo.setSelected(z16);
    }

    public void setShowingHintText(boolean z16) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mInfo.setShowingHintText(z16);
        } else {
            setBooleanProperty(4, z16);
        }
    }

    public void setSource(View view) {
        this.mVirtualDescendantId = -1;
        this.mInfo.setSource(view);
    }

    public void setStateDescription(@Nullable CharSequence charSequence) {
        if (BuildCompat.isAtLeastR()) {
            this.mInfo.setStateDescription(charSequence);
        } else {
            this.mInfo.getExtras().putCharSequence(STATE_DESCRIPTION_KEY, charSequence);
        }
    }

    public void setText(CharSequence charSequence) {
        this.mInfo.setText(charSequence);
    }

    public void setTextEntryKey(boolean z16) {
        if (Build.VERSION.SDK_INT >= 29) {
            this.mInfo.setTextEntryKey(z16);
        } else {
            setBooleanProperty(8, z16);
        }
    }

    public void setTextSelection(int i3, int i16) {
        this.mInfo.setTextSelection(i3, i16);
    }

    public void setTooltipText(@Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.mInfo.setTooltipText(charSequence);
        } else {
            this.mInfo.getExtras().putCharSequence(TOOLTIP_TEXT_KEY, charSequence);
        }
    }

    public void setTouchDelegateInfo(@NonNull TouchDelegateInfoCompat touchDelegateInfoCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            this.mInfo.setTouchDelegateInfo(touchDelegateInfoCompat.mInfo);
        }
    }

    public void setTraversalAfter(View view) {
        this.mInfo.setTraversalAfter(view);
    }

    public void setTraversalBefore(View view) {
        this.mInfo.setTraversalBefore(view);
    }

    public void setViewIdResourceName(String str) {
        this.mInfo.setViewIdResourceName(str);
    }

    public void setVisibleToUser(boolean z16) {
        this.mInfo.setVisibleToUser(z16);
    }

    @NonNull
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
        List<AccessibilityActionCompat> actionList = getActionList();
        for (int i3 = 0; i3 < actionList.size(); i3++) {
            AccessibilityActionCompat accessibilityActionCompat = actionList.get(i3);
            String actionSymbolicName = getActionSymbolicName(accessibilityActionCompat.getId());
            if (actionSymbolicName.equals("ACTION_UNKNOWN") && accessibilityActionCompat.getLabel() != null) {
                actionSymbolicName = accessibilityActionCompat.getLabel().toString();
            }
            sb5.append(actionSymbolicName);
            if (i3 != actionList.size() - 1) {
                sb5.append(", ");
            }
        }
        sb5.append("]");
        return sb5.toString();
    }

    public AccessibilityNodeInfo unwrap() {
        return this.mInfo;
    }

    public static AccessibilityNodeInfoCompat obtain(View view, int i3) {
        return wrapNonNullInstance(AccessibilityNodeInfo.obtain(view, i3));
    }

    public void addAction(AccessibilityActionCompat accessibilityActionCompat) {
        this.mInfo.addAction((AccessibilityNodeInfo.AccessibilityAction) accessibilityActionCompat.mAction);
    }

    public void addChild(View view, int i3) {
        this.mInfo.addChild(view, i3);
    }

    public boolean performAction(int i3, Bundle bundle) {
        return this.mInfo.performAction(i3, bundle);
    }

    public boolean removeChild(View view, int i3) {
        return this.mInfo.removeChild(view, i3);
    }

    public void setLabelFor(View view, int i3) {
        this.mInfo.setLabelFor(view, i3);
    }

    public void setLabeledBy(View view, int i3) {
        this.mInfo.setLabeledBy(view, i3);
    }

    public void setTraversalAfter(View view, int i3) {
        this.mInfo.setTraversalAfter(view, i3);
    }

    public void setTraversalBefore(View view, int i3) {
        this.mInfo.setTraversalBefore(view, i3);
    }

    public void setParent(View view, int i3) {
        this.mParentVirtualDescendantId = i3;
        this.mInfo.setParent(view, i3);
    }

    public void setSource(View view, int i3) {
        this.mVirtualDescendantId = i3;
        this.mInfo.setSource(view, i3);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class TouchDelegateInfoCompat {
        final AccessibilityNodeInfo.TouchDelegateInfo mInfo;

        public TouchDelegateInfoCompat(@NonNull Map<Region, View> map) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.mInfo = new AccessibilityNodeInfo.TouchDelegateInfo(map);
            } else {
                this.mInfo = null;
            }
        }

        @Nullable
        public Region getRegionAt(@IntRange(from = 0) int i3) {
            Region regionAt;
            if (Build.VERSION.SDK_INT >= 29) {
                regionAt = this.mInfo.getRegionAt(i3);
                return regionAt;
            }
            return null;
        }

        @IntRange(from = 0)
        public int getRegionCount() {
            int regionCount;
            if (Build.VERSION.SDK_INT >= 29) {
                regionCount = this.mInfo.getRegionCount();
                return regionCount;
            }
            return 0;
        }

        /* JADX WARN: Code restructure failed: missing block: B:3:0x0006, code lost:
        
            r3 = r2.mInfo.getTargetForRegion(r3);
         */
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public AccessibilityNodeInfoCompat getTargetForRegion(@NonNull Region region) {
            AccessibilityNodeInfo targetForRegion;
            if (Build.VERSION.SDK_INT >= 29 && targetForRegion != null) {
                return AccessibilityNodeInfoCompat.wrap(targetForRegion);
            }
            return null;
        }

        TouchDelegateInfoCompat(@NonNull AccessibilityNodeInfo.TouchDelegateInfo touchDelegateInfo) {
            this.mInfo = touchDelegateInfo;
        }
    }

    public static AccessibilityNodeInfoCompat obtain() {
        return wrap(AccessibilityNodeInfo.obtain());
    }

    AccessibilityNodeInfoCompat(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.mInfo = accessibilityNodeInfo;
    }

    public static AccessibilityNodeInfoCompat obtain(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        return wrap(AccessibilityNodeInfo.obtain(accessibilityNodeInfoCompat.mInfo));
    }
}
