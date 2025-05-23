package cooperation.qzone.share;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.o;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes38.dex */
public class InputViewPanelControl {
    public static String ReplaceFormatUser(String str, List<Friend> list) {
        return FormatAtUsers(str, list);
    }

    public static String atUsersToString(List<Friend> list) {
        StringBuffer stringBuffer = new StringBuffer();
        if (list != null && list.size() != 0) {
            for (Friend friend : list) {
                String str = friend.mName;
                if (str == null) {
                    str = friend.mUin + "";
                }
                stringBuffer.append("@{uin:" + friend.mUin + ",nick:" + str.replace("%", "%25").replace(",", "%2C").replace("}", "%7D") + "}");
            }
            return stringBuffer.toString();
        }
        return stringBuffer.toString();
    }

    public static SystemEmoticonPanel createEmoPanel(Context context, final EditText editText) {
        try {
            return new SystemEmoticonPanel(context, new EmoticonCallback() { // from class: cooperation.qzone.share.InputViewPanelControl.1
                @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
                public void delete() {
                    EditText editText2 = editText;
                    if (editText2 == null || editText2.getSelectionStart() == 0) {
                        return;
                    }
                    try {
                        Editable text = editText.getText();
                        int selectionStart = editText.getSelectionStart();
                        int offsetBefore = TextUtils.getOffsetBefore(editText.getText(), selectionStart);
                        if (selectionStart != offsetBefore) {
                            text.delete(Math.min(selectionStart, offsetBefore), Math.max(selectionStart, offsetBefore));
                        }
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }

                @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
                public boolean onLongClick(EmoticonInfo emoticonInfo) {
                    return true;
                }

                @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
                public void send() {
                }

                @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
                public void send(EmoticonInfo emoticonInfo) {
                    EditText editText2;
                    EditText editText3;
                    if (emoticonInfo == null || (editText2 = editText) == null || !(emoticonInfo instanceof SystemEmoticonInfo)) {
                        return;
                    }
                    int selectionStart = editText2.getSelectionStart();
                    int selectionEnd = editText.getSelectionEnd();
                    if (selectionStart < 0 || selectionEnd < 0 || selectionEnd < selectionStart || (editText3 = editText) == null || editText3.getEditableText() == null) {
                        return;
                    }
                    editText.getEditableText().replace(selectionStart, selectionEnd, com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(((SystemEmoticonInfo) emoticonInfo).code));
                }

                @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
                public void emoticonMall() {
                }

                @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
                public void setting() {
                }

                @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
                public void onHidePopup(EmoticonInfo emoticonInfo) {
                }

                @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
                public void onShowPopup(EmoticonInfo emoticonInfo, EmoticonInfo emoticonInfo2, Drawable drawable) {
                }
            });
        } catch (Throwable th5) {
            QLog.e("QZoneShareActivity", 1, th5.getStackTrace());
            return null;
        }
    }

    public static int findAtSymbol(CharSequence charSequence, int i3, int i16, List<Friend> list, int i17, int i18, String str) {
        if (charSequence != null) {
            if (charSequence.length() > 1) {
                int length = charSequence.length() > i3 ? i3 : charSequence.length();
                int i19 = length - 1;
                for (int i26 = 1; i19 >= 0 && i26 <= i16; i26++) {
                    if (charSequence.charAt(i19) == '@' && isMatchAt(charSequence.toString().substring(i19, length), false, list, i17, i18, str)) {
                        return i19;
                    }
                    i19--;
                }
            }
        }
        return -1;
    }

    public static boolean isMatchAt(String str, boolean z16, List<Friend> list, int i3, int i16, String str2) {
        if ((isDelAt(i3, i16, str2) || !z16) && list != null) {
            int size = list.size();
            for (int i17 = 0; i17 < size; i17++) {
                Friend friend = list.get(i17);
                if (friend != null && friend.mName != null && str != null) {
                    if (!str.equalsIgnoreCase("@" + friend.mName)) {
                        if (str.equalsIgnoreCase("@" + friend.mName + " ")) {
                        }
                    }
                    if (!z16) {
                        return true;
                    }
                    list.remove(i17);
                    return true;
                }
            }
        }
        return false;
    }

    public static String replace(String str, String str2, String str3) {
        int indexOf = str.indexOf(str2, 0);
        if (indexOf == -1) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder(str);
        sb5.replace(indexOf, str2.length() + indexOf, str3);
        return sb5.toString();
    }

    public static String getEditText(EditText editText, List<Friend> list) {
        if (editText != null) {
            String palinText = getPalinText(editText);
            if (!TextUtils.isEmpty(palinText)) {
                return ReplaceFormatUser(palinText, list).replaceAll(HardCodeUtil.qqStr(R.string.nfx), HardCodeUtil.qqStr(R.string.f172112ng1)).replaceAll(HardCodeUtil.qqStr(R.string.nfy), "/MM");
            }
            return "";
        }
        return "";
    }

    public static String getPalinText(EditText editText) {
        QQTextBuilder qQTextBuilder;
        if (editText == null) {
            return null;
        }
        if ((editText.getText() instanceof QQTextBuilder) && (qQTextBuilder = (QQTextBuilder) editText.getText()) != null) {
            return qQTextBuilder.toPlainText();
        }
        if (editText.getEditableText() != null) {
            return editText.getEditableText().toString();
        }
        return null;
    }

    public static void insertStrToEdit(String str, int i3, EditText editText) {
        if (editText == null || TextUtils.isEmpty(str) || i3 < 0) {
            return;
        }
        Editable newEditable = o.f292704d.newEditable(editText.getText());
        newEditable.insert(i3, str);
        try {
            editText.setText(newEditable);
        } catch (IndexOutOfBoundsException unused) {
            newEditable.append((CharSequence) " ");
            editText.setText(newEditable);
        }
        editText.setSelection(i3 + str.length());
    }

    public static String replaceFirst(String str, String str2, String str3) {
        try {
            return Pattern.compile(str, 16).matcher(str2).replaceFirst(str3);
        } catch (Exception unused) {
            return replace(str2, str, str3);
        }
    }

    public static int addAtUser(EditText editText, ArrayList<ResultRecord> arrayList, List<Friend> list, int i3) {
        if (arrayList == null) {
            return i3;
        }
        Iterator<ResultRecord> it = arrayList.iterator();
        while (it.hasNext()) {
            ResultRecord next = it.next();
            Friend friend = new Friend();
            if (!TextUtils.isEmpty(next.name)) {
                friend.mName = next.name;
            } else {
                friend.mName = next.uin;
            }
            try {
                long longValue = Long.valueOf(next.uin).longValue();
                friend.mUin = longValue;
                if (friend.mName != null && longValue != 0) {
                    if (list == null) {
                        return i3;
                    }
                    list.add(friend);
                    String str = "@" + friend.mName + " ";
                    if (i3 < str.length()) {
                        i3 = str.length();
                    }
                    insertStrToEdit(str, editText.getSelectionStart(), editText);
                }
            } catch (NumberFormatException unused) {
            }
        }
        return i3;
    }

    public static boolean isTouchSpecialView(MotionEvent motionEvent, EditText editText, int i3, int i16, View view) {
        if (editText != null) {
            int x16 = (int) motionEvent.getX();
            int y16 = (int) (motionEvent.getY() + i3 + i16);
            Rect viewRect = getViewRect(editText);
            if (viewRect != null && viewRect.contains(x16, y16)) {
                return true;
            }
        }
        if (view == null) {
            return false;
        }
        int x17 = (int) motionEvent.getX();
        int y17 = (int) (motionEvent.getY() + i3 + i16);
        Rect viewRect2 = getViewRect(view);
        return viewRect2 != null && viewRect2.contains(x17, y17);
    }

    public static Rect getViewRect(View view) {
        if (view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i3 = iArr[0];
        return new Rect(i3, iArr[1], view.getWidth() + i3, iArr[1] + view.getHeight());
    }

    public static String FormatAtUsers(String str, List<Friend> list) {
        if (str == null) {
            return null;
        }
        if (list != null && list.size() != 0) {
            for (Friend friend : list) {
                String str2 = friend.mName;
                if (str2 == null) {
                    str2 = friend.mUin + "";
                }
                String str3 = "@{uin:" + friend.mUin + ",nick:" + str2.replace("%", "%25").replace(",", "%2C").replace("}", "%7D") + "}";
                String str4 = "@" + friend.mName;
                if (!TextUtils.isEmpty(friend.mName) && str.contains(str4)) {
                    str = replaceFirst(str4, str, str3);
                }
            }
        }
        return str;
    }

    public static boolean isDelAt(int i3, int i16, String str) {
        return (i3 == -1 || i16 == -1 || str == null || str.length() <= 0) ? false : true;
    }
}
