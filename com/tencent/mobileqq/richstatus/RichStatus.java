package com.tencent.mobileqq.richstatus;

import android.R;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.ITopic;
import com.tencent.mobileqq.text.OffsetableImageSpan;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.widget.StatableSpanTextView;
import com.tencent.mobileqq.widget.bo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.httpcore.message.TokenParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class RichStatus implements Cloneable, Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final int ACTION_COLOR_NORMAL = -8947849;
    public static final int ACTION_COLOR_PRESSED = -2039584;
    public static final float ACTION_SPAN_RESIZE_FACTOR = 1.1f;
    public static final String EVENT_SPAN_PLACE_HOLDER = "[S]";
    public static final String LOC_SPAN_PLACE_HOLDER = "[L]";
    public static final float LOC_SPAN_RESIZE_FACTOR = 0.9f;
    public static final float OFFSET_IMAGE_SPAN = -0.1f;
    public static final int SPAN_ALIGN_MODE = 0;
    public static final int TOPIC_COLOR = -16737793;
    public static final int TOPIC_COLOR_PRESSED = -2147444225;

    /* renamed from: d, reason: collision with root package name */
    private static RichStatus f282151d = null;
    public static final ColorStateList sActionColor;
    private static final long serialVersionUID = 1;
    public int actId;
    public int actionId;
    public String actionText;
    private String cachedStatusContent;
    private String cachedStatusHeader;
    public int dataId;
    public String dataText;
    public boolean enableSummaryCached;
    public String feedsId;
    public int fontId;
    public int fontType;
    private boolean isEmptyStatus;
    public boolean isFirstReadUins;
    public byte[] key;
    public int latitude;
    public int locationPosition;
    public String locationText;
    public int lontitude;
    public ArrayList<StickerInfo> mStickerInfos;
    private int mTopicColor;
    private int mTopicPressedColor;
    public List<String> mUins;
    public ArrayList<String> plainText;
    public HashMap<Integer, b> sigZanInfo;
    public int signType;
    public long time;
    public List<Pair<Integer, String>> topics;
    public List<Pair<Integer, Integer>> topicsPos;
    public int tplId;
    public int tplType;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class StickerInfo implements Serializable {
        static IPatchRedirector $redirector_;
        public float height;

        /* renamed from: id, reason: collision with root package name */
        public int f282152id;
        public float posX;
        public float posY;
        public float width;

        public StickerInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements Comparator<Pair<Integer, Integer>> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RichStatus.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Pair<Integer, Integer> pair, Pair<Integer, Integer> pair2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) pair, (Object) pair2)).intValue();
            }
            if (pair.second.intValue() < pair2.second.intValue()) {
                return -1;
            }
            return 1;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f282154a;

        /* renamed from: b, reason: collision with root package name */
        public int f282155b;

        /* renamed from: c, reason: collision with root package name */
        public int f282156c;

        /* renamed from: d, reason: collision with root package name */
        public int f282157d;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43768);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 35)) {
            redirector.redirect((short) 35);
        } else {
            f282151d = null;
            sActionColor = new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[0]}, new int[]{ACTION_COLOR_PRESSED, ACTION_COLOR_NORMAL});
        }
    }

    public RichStatus(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        this.isEmptyStatus = false;
        this.mTopicColor = 0;
        this.mTopicPressedColor = 0;
        this.cachedStatusHeader = null;
        this.cachedStatusContent = null;
        this.enableSummaryCached = false;
        this.actionId = 0;
        this.dataId = 0;
        this.isFirstReadUins = true;
        this.topics = new ArrayList();
        this.topicsPos = new ArrayList();
        if (str != null) {
            ArrayList<String> arrayList = new ArrayList<>();
            this.plainText = arrayList;
            arrayList.add(str);
        }
    }

    private void a(String str) {
        if (this.plainText == null) {
            this.plainText = new ArrayList<>();
        }
        this.plainText.add(str);
    }

    private static int b(String str) {
        return str.getBytes().length;
    }

    private ColorStateList c(int i3, int i16) {
        return new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[]{0}}, new int[]{i16, i3});
    }

    private Resources d() {
        BaseApplication context = BaseApplication.getContext();
        if (context == null) {
            return null;
        }
        return context.getResources();
    }

    private int e() {
        int i3 = this.mTopicColor;
        if (i3 != 0) {
            return i3;
        }
        Resources d16 = d();
        if (d16 == null) {
            return TOPIC_COLOR;
        }
        int color = d16.getColor(com.tencent.mobileqq.R.color.qui_common_text_link);
        this.mTopicColor = color;
        return color;
    }

    private int f() {
        int i3 = this.mTopicPressedColor;
        if (i3 != 0) {
            return i3;
        }
        Resources d16 = d();
        if (d16 == null) {
            return TOPIC_COLOR_PRESSED;
        }
        int color = d16.getColor(com.tencent.mobileqq.R.color.qui_common_text_link_pressed);
        this.mTopicPressedColor = color;
        return color;
    }

    public static RichStatus getEmptyStatus() {
        if (f282151d == null) {
            f282151d = new RichStatus(null);
        }
        return f282151d;
    }

    private void h(SpannableStringBuilder spannableStringBuilder, String str) {
        if (!TextUtils.isEmpty(str)) {
            spannableStringBuilder.append((CharSequence) str);
        }
    }

    private void i(StringBuilder sb5, String str) {
        if (!TextUtils.isEmpty(str)) {
            sb5.append(str);
        }
    }

    private void j(ByteBuffer byteBuffer, int i3, String str) {
        if (!TextUtils.isEmpty(str)) {
            byte[] bytes = str.getBytes();
            byteBuffer.put((byte) i3).put((byte) bytes.length).put(bytes, 0, bytes.length);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:28:0x00b9. Please report as an issue. */
    public static RichStatus parseStatus(byte[] bArr) {
        RichStatus richStatus = new RichStatus(null);
        if (bArr != null && bArr.length > 2) {
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN);
            String str = null;
            int i3 = 0;
            while (true) {
                if (order.hasRemaining()) {
                    if (order.remaining() < 2) {
                        if (QLog.isDebugVersion()) {
                            QLog.d("Q.richstatus.status", 2, HexUtil.bytes2HexStr(bArr));
                        }
                    } else {
                        int i16 = order.get();
                        int i17 = order.get();
                        if (i16 < 0) {
                            i16 += 256;
                        }
                        if (i17 < 0) {
                            i17 += 256;
                        }
                        if (order.remaining() < i17) {
                            if (QLog.isDebugVersion()) {
                                QLog.d("Q.richstatus.status", 2, HexUtil.bytes2HexStr(bArr));
                            }
                        } else {
                            int i18 = i3 + 2;
                            if (i16 > 0 && i16 < 128) {
                                String str2 = new String(bArr, i18, i17);
                                i3 = i18 + i17;
                                order.position(i3);
                                if (i16 != 1) {
                                    if (i16 != 2) {
                                        if (i16 != 4) {
                                            if (str == null) {
                                                str = str2;
                                            } else {
                                                str = str + str2;
                                            }
                                        } else {
                                            if (str != null) {
                                                richStatus.a(str);
                                                str = null;
                                            }
                                            ArrayList<String> arrayList = richStatus.plainText;
                                            if (arrayList != null) {
                                                richStatus.locationPosition = arrayList.size();
                                            } else {
                                                richStatus.locationPosition = 0;
                                            }
                                            richStatus.locationText = str2;
                                        }
                                    } else {
                                        richStatus.dataText = str2;
                                    }
                                } else {
                                    richStatus.actionText = str2;
                                }
                            } else {
                                if (i16 != 129) {
                                    if (i16 != 130) {
                                        switch (i16) {
                                            case 144:
                                                richStatus.feedsId = new String(bArr, i18, i17);
                                                if (QLog.isDebugVersion()) {
                                                    QLog.d("Q.richstatus.status", 2, HexUtil.bytes2HexStr(bArr) + ",sign feeds id=" + richStatus.feedsId);
                                                    break;
                                                }
                                                break;
                                            case 145:
                                                richStatus.tplId = order.getInt();
                                                break;
                                            case 146:
                                                richStatus.tplType = order.getInt();
                                                break;
                                            case 147:
                                                richStatus.actId = order.getInt();
                                                break;
                                            case 148:
                                                if (order.remaining() < 4) {
                                                    if (QLog.isColorLevel()) {
                                                        QLog.d("Q.richstatus.status", 2, HexUtil.bytes2HexStr(bArr));
                                                        break;
                                                    }
                                                } else {
                                                    int i19 = order.getInt();
                                                    if (i17 > 4) {
                                                        String str3 = new String(bArr, i18 + 4, i17 - 4);
                                                        if (!str3.isEmpty()) {
                                                            richStatus.topics.add(new Pair<>(Integer.valueOf(i19), str3));
                                                            break;
                                                        }
                                                    }
                                                }
                                                break;
                                            case 149:
                                                if (order.remaining() < 5) {
                                                    if (QLog.isDebugVersion()) {
                                                        QLog.d("Q.richstatus.status", 2, HexUtil.bytes2HexStr(bArr));
                                                    }
                                                    QLog.e("RichStatus", 1, "parseStatus error, T_TOPIC_POS remaining not enough!");
                                                    break;
                                                } else {
                                                    for (int i26 = i17; i26 >= 5; i26 -= 5) {
                                                        int i27 = order.getInt();
                                                        int i28 = order.get();
                                                        if (i28 < 0) {
                                                            i28 += 256;
                                                        }
                                                        richStatus.topicsPos.add(new Pair<>(Integer.valueOf(i27), Integer.valueOf(i28)));
                                                    }
                                                    break;
                                                }
                                            default:
                                                switch (i16) {
                                                    case 161:
                                                        byte[] bArr2 = new byte[i17];
                                                        order.get(bArr2);
                                                        richstatus_sticker$RichStatus_Sticker richstatus_sticker_richstatus_sticker = new richstatus_sticker$RichStatus_Sticker();
                                                        try {
                                                            richstatus_sticker_richstatus_sticker.mergeFrom(bArr2);
                                                            if (richstatus_sticker_richstatus_sticker.sticker_info.has() && richstatus_sticker_richstatus_sticker.sticker_info.size() > 0) {
                                                                ArrayList<StickerInfo> arrayList2 = richStatus.mStickerInfos;
                                                                if (arrayList2 == null) {
                                                                    richStatus.mStickerInfos = new ArrayList<>();
                                                                } else {
                                                                    arrayList2.clear();
                                                                }
                                                                for (int i29 = 0; i29 < richstatus_sticker_richstatus_sticker.sticker_info.size(); i29++) {
                                                                    richstatus_sticker$StickerInfo richstatus_sticker_stickerinfo = richstatus_sticker_richstatus_sticker.sticker_info.get(i29);
                                                                    StickerInfo stickerInfo = new StickerInfo();
                                                                    stickerInfo.f282152id = richstatus_sticker_stickerinfo.uint32_id.get();
                                                                    stickerInfo.posX = richstatus_sticker_stickerinfo.float_posX.get();
                                                                    stickerInfo.posY = richstatus_sticker_stickerinfo.float_posY.get();
                                                                    stickerInfo.width = richstatus_sticker_stickerinfo.float_width.get();
                                                                    stickerInfo.height = richstatus_sticker_stickerinfo.float_height.get();
                                                                    richStatus.mStickerInfos.add(stickerInfo);
                                                                }
                                                                break;
                                                            }
                                                        } catch (InvalidProtocolBufferMicroException e16) {
                                                            QLog.e("RichStatus", 1, "parse sticker error: ", e16);
                                                            break;
                                                        }
                                                        break;
                                                    case 162:
                                                        richStatus.fontId = order.getInt();
                                                        break;
                                                    case 163:
                                                        richStatus.fontType = order.getInt();
                                                        break;
                                                }
                                        }
                                    } else if (order.remaining() < 8) {
                                        if (QLog.isDebugVersion()) {
                                            QLog.d("Q.richstatus.status", 2, HexUtil.bytes2HexStr(bArr));
                                        }
                                    } else {
                                        richStatus.lontitude = order.getInt();
                                        richStatus.latitude = order.getInt();
                                    }
                                } else if (order.remaining() < 8) {
                                    if (QLog.isDebugVersion()) {
                                        QLog.d("Q.richstatus.status", 2, HexUtil.bytes2HexStr(bArr));
                                    }
                                } else {
                                    richStatus.actionId = order.getInt();
                                    richStatus.dataId = order.getInt();
                                }
                                i3 = i18 + i17;
                                order.position(i3);
                            }
                        }
                    }
                }
            }
            if (str != null) {
                richStatus.a(str);
            }
        }
        return richStatus;
    }

    public boolean bOnlyHasTopic() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this)).booleanValue();
        }
        if (this.topics.size() == 0 || !TextUtils.isEmpty(this.actionText)) {
            return false;
        }
        ArrayList<String> arrayList = this.plainText;
        if (arrayList == null || arrayList.size() == 0) {
            return true;
        }
        StringBuilder sb5 = new StringBuilder();
        for (int i16 = 0; i16 < this.locationPosition; i16++) {
            i(sb5, this.plainText.get(i16));
        }
        ArrayList<String> arrayList2 = this.plainText;
        if (arrayList2 != null) {
            i3 = arrayList2.size();
        } else {
            i3 = 0;
        }
        for (int i17 = this.locationPosition; i17 < i3; i17++) {
            i(sb5, this.plainText.get(i17));
        }
        if (sb5.toString().trim().length() != 0) {
            return false;
        }
        return true;
    }

    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.i("RichStatus", 2, QCircleLpReportDc05507.KEY_CLEAR);
        }
        this.tplId = 0;
        this.fontId = 0;
        this.fontType = 0;
        this.actionId = 0;
        this.actionText = null;
        this.dataId = 0;
        this.dataText = "";
        this.mStickerInfos = null;
        this.locationText = "";
    }

    public Object clone() {
        RichStatus richStatus;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return iPatchRedirector.redirect((short) 19, (Object) this);
        }
        try {
            richStatus = (RichStatus) super.clone();
        } catch (CloneNotSupportedException e16) {
            e16.printStackTrace();
            richStatus = null;
        }
        if (richStatus == null) {
            return new RichStatus("");
        }
        ArrayList<String> arrayList = this.plainText;
        if (arrayList != null) {
            richStatus.plainText = (ArrayList) arrayList.clone();
        }
        if (this.topics.size() > 0) {
            richStatus.topics.clear();
            richStatus.topics.addAll(this.topics);
        }
        if (this.topicsPos.size() > 0) {
            richStatus.topicsPos.clear();
            richStatus.topicsPos.addAll(this.topicsPos);
        }
        return richStatus;
    }

    public void copyFrom(RichStatus richStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) richStatus);
            return;
        }
        if (richStatus == null) {
            return;
        }
        this.tplId = richStatus.tplId;
        this.fontId = richStatus.fontId;
        this.fontType = richStatus.fontType;
        this.actionId = richStatus.actionId;
        this.actionText = richStatus.actionText;
        ArrayList<String> arrayList = richStatus.plainText;
        if (arrayList != null) {
            this.plainText = (ArrayList) arrayList.clone();
        } else {
            this.plainText = null;
        }
        this.topics.clear();
        this.topics.addAll(richStatus.topics);
        this.topicsPos.clear();
        this.topicsPos.addAll(richStatus.topicsPos);
        this.locationText = richStatus.locationText;
    }

    public int countLength() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return ((countUtfLength() - 12) + 2) / 3;
    }

    public int countUtfLength() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        if (!TextUtils.isEmpty(this.actionText)) {
            i3 = b(this.actionText) + 12 + 0;
        } else {
            i3 = 0;
        }
        if (!TextUtils.isEmpty(this.dataText)) {
            i3 += b(this.dataText) + 2;
        }
        if (!TextUtils.isEmpty(this.locationText)) {
            i3 += b(this.locationText) + 12;
        }
        for (int i16 = 0; i16 < this.topics.size(); i16++) {
            String str = this.topics.get(i16).second;
            if (!TextUtils.isEmpty(str)) {
                i3 += b(str) + 6;
            }
        }
        List<Pair<Integer, Integer>> list = this.topicsPos;
        if (list != null && list.size() > 0) {
            i3 += (this.topicsPos.size() * 5) + 2;
        }
        ArrayList<String> arrayList = this.plainText;
        if (arrayList != null) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next)) {
                    i3 += b(next) + 2;
                }
            }
        }
        int i17 = i3 + 24;
        ArrayList<StickerInfo> arrayList2 = this.mStickerInfos;
        if (arrayList2 != null && arrayList2.size() > 0) {
            richstatus_sticker$RichStatus_Sticker richstatus_sticker_richstatus_sticker = new richstatus_sticker$RichStatus_Sticker();
            for (int i18 = 0; i18 < this.mStickerInfos.size(); i18++) {
                StickerInfo stickerInfo = this.mStickerInfos.get(i18);
                richstatus_sticker$StickerInfo richstatus_sticker_stickerinfo = new richstatus_sticker$StickerInfo();
                richstatus_sticker_stickerinfo.uint32_id.set(stickerInfo.f282152id);
                richstatus_sticker_stickerinfo.float_posX.set(stickerInfo.posX);
                richstatus_sticker_stickerinfo.float_posY.set(stickerInfo.posY);
                richstatus_sticker_stickerinfo.float_width.set(stickerInfo.width);
                richstatus_sticker_stickerinfo.float_height.set(stickerInfo.height);
                richstatus_sticker_richstatus_sticker.sticker_info.add(richstatus_sticker_stickerinfo);
            }
            return i17 + richstatus_sticker_richstatus_sticker.toByteArray().length + 2;
        }
        return i17;
    }

    public byte[] encode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (byte[]) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        ByteBuffer allocate = ByteBuffer.allocate(countUtfLength());
        allocate.order(ByteOrder.BIG_ENDIAN);
        j(allocate, 1, this.actionText);
        j(allocate, 2, this.dataText);
        for (int i3 = 0; i3 < this.topics.size(); i3++) {
            int intValue = this.topics.get(i3).first.intValue();
            String str = this.topics.get(i3).second;
            if (!TextUtils.isEmpty(str)) {
                int b16 = b(str) + 4;
                byte[] bytes = str.getBytes();
                allocate.put((byte) -108).put((byte) b16).putInt(intValue).put(bytes, 0, bytes.length);
            }
        }
        List<Pair<Integer, Integer>> list = this.topicsPos;
        if (list != null && list.size() > 0) {
            allocate.put((byte) -107).put((byte) (this.topicsPos.size() * 5));
            for (int i16 = 0; i16 < this.topicsPos.size(); i16++) {
                allocate.putInt(this.topicsPos.get(i16).first.intValue()).put((byte) this.topicsPos.get(i16).second.intValue());
            }
        }
        if (this.plainText != null) {
            for (int i17 = 0; i17 < this.locationPosition; i17++) {
                j(allocate, 3, this.plainText.get(i17));
            }
        }
        j(allocate, 4, this.locationText);
        ArrayList<String> arrayList = this.plainText;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i18 = this.locationPosition; i18 < size; i18++) {
                j(allocate, 3, this.plainText.get(i18));
            }
        }
        if (!TextUtils.isEmpty(this.actionText)) {
            allocate.put((byte) -127).put((byte) 8).putInt(this.actionId).putInt(this.dataId);
        }
        if (!TextUtils.isEmpty(this.locationText)) {
            allocate.put((byte) -126).put((byte) 8).putInt(this.lontitude).putInt(this.latitude);
        }
        allocate.put((byte) -111).put((byte) 4).putInt(this.tplId);
        allocate.put((byte) -110).put((byte) 4).putInt(this.tplType);
        allocate.put((byte) -94).put((byte) 4).putInt(this.fontId);
        allocate.put((byte) -93).put((byte) 4).putInt(this.fontType);
        ArrayList<StickerInfo> arrayList2 = this.mStickerInfos;
        if (arrayList2 != null && arrayList2.size() > 0) {
            richstatus_sticker$RichStatus_Sticker richstatus_sticker_richstatus_sticker = new richstatus_sticker$RichStatus_Sticker();
            for (int i19 = 0; i19 < this.mStickerInfos.size(); i19++) {
                StickerInfo stickerInfo = this.mStickerInfos.get(i19);
                richstatus_sticker$StickerInfo richstatus_sticker_stickerinfo = new richstatus_sticker$StickerInfo();
                richstatus_sticker_stickerinfo.uint32_id.set(stickerInfo.f282152id);
                richstatus_sticker_stickerinfo.float_posX.set(stickerInfo.posX);
                richstatus_sticker_stickerinfo.float_posY.set(stickerInfo.posY);
                richstatus_sticker_stickerinfo.float_width.set(stickerInfo.width);
                richstatus_sticker_stickerinfo.float_height.set(stickerInfo.height);
                richstatus_sticker_richstatus_sticker.sticker_info.add(richstatus_sticker_stickerinfo);
            }
            byte[] byteArray = richstatus_sticker_richstatus_sticker.toByteArray();
            allocate.put((byte) -95).put((byte) byteArray.length).put(byteArray);
            if (QLog.isDebugVersion()) {
                QLog.d("RichStatus", 2, "encode sticker info size = " + this.mStickerInfos.size() + " buffer length = " + byteArray.length);
            }
        }
        return allocate.array();
    }

    public void ensureContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
        } else if (this.plainText == null) {
            ArrayList<String> arrayList = new ArrayList<>(2);
            this.plainText = arrayList;
            arrayList.add("");
            this.plainText.add("");
        }
    }

    public String getActionAndData() {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        if (this.enableSummaryCached && (str2 = this.cachedStatusHeader) != null) {
            return str2;
        }
        if (TextUtils.isEmpty(this.actionText)) {
            str = "";
        } else if (TextUtils.isEmpty(this.dataText)) {
            str = this.actionText;
        } else {
            str = this.actionText + this.dataText;
        }
        if (this.enableSummaryCached) {
            this.cachedStatusHeader = str;
        }
        return str;
    }

    public CharSequence getLocSS(TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? getLocSS(textView, "") : (CharSequence) iPatchRedirector.redirect((short) 8, (Object) this, (Object) textView);
    }

    public String getPlainText() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        if (this.enableSummaryCached && (str = this.cachedStatusContent) != null) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder(100);
        if (shouldShowAtHead()) {
            for (int i3 = 0; i3 < this.topics.size(); i3++) {
                sb5.append(this.topics.get(i3).second);
            }
        }
        if (this.plainText != null) {
            for (int i16 = 0; i16 < this.locationPosition; i16++) {
                i(sb5, this.plainText.get(i16));
            }
            int size = this.plainText.size();
            for (int i17 = this.locationPosition; i17 < size; i17++) {
                i(sb5, this.plainText.get(i17));
            }
        }
        if (shouldShowMixing()) {
            sortTopicPos();
            for (int i18 = 0; i18 < this.topicsPos.size(); i18++) {
                String topicStrById = getTopicStrById(this.topicsPos.get(i18).first.intValue());
                if (!TextUtils.isEmpty(topicStrById)) {
                    int intValue = this.topicsPos.get(i18).second.intValue();
                    if (intValue > sb5.length()) {
                        break;
                    }
                    sb5.insert(intValue, topicStrById);
                }
            }
        }
        if (this.enableSummaryCached) {
            this.cachedStatusContent = sb5.toString();
        }
        return sb5.toString();
    }

    public String getTopicStrById(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this, i3);
        }
        List<Pair<Integer, String>> list = this.topics;
        if (list != null && list.size() > 0) {
            for (int i16 = 0; i16 < this.topics.size(); i16++) {
                if (this.topics.get(i16).first.intValue() == i3) {
                    return this.topics.get(i16).second;
                }
            }
        }
        return null;
    }

    public int getTotalLenForShow() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Integer) iPatchRedirector.redirect((short) 33, (Object) this)).intValue();
        }
        CharSequence spannableStringWithoutAction = toSpannableStringWithoutAction(null);
        if (!TextUtils.isEmpty(this.actionText)) {
            i3 = 4;
        } else {
            i3 = 0;
        }
        return i3 + spannableStringWithoutAction.length();
    }

    public boolean hasTopic() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        List<Pair<Integer, String>> list = this.topics;
        if (list != null && list.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        ArrayList<String> arrayList = this.plainText;
        if (arrayList != null) {
            Iterator<String> it = arrayList.iterator();
            z16 = true;
            while (it.hasNext()) {
                if (!TextUtils.isEmpty(it.next())) {
                    z16 = false;
                }
            }
        } else {
            z16 = true;
        }
        if (this.actionId != 0 || this.dataId != 0 || !z16 || !this.topics.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean isEmptyStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.isEmptyStatus;
    }

    public void setEmptyStatus(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.isEmptyStatus = z16;
        }
    }

    public boolean shouldShowAtHead() {
        List<Pair<Integer, Integer>> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this)).booleanValue();
        }
        List<Pair<Integer, String>> list2 = this.topics;
        if (list2 != null && list2.size() > 0 && ((list = this.topicsPos) == null || list.size() <= 0)) {
            return true;
        }
        return false;
    }

    public boolean shouldShowMixing() {
        List<Pair<Integer, Integer>> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this)).booleanValue();
        }
        List<Pair<Integer, String>> list2 = this.topics;
        if (list2 != null && list2.size() > 0 && (list = this.topicsPos) != null && list.size() == this.topics.size()) {
            return true;
        }
        return false;
    }

    public void sortTopicPos() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        List<Pair<Integer, Integer>> list = this.topicsPos;
        if (list != null && list.size() > 1) {
            Collections.sort(this.topicsPos, new a());
        }
    }

    public SpannableString toSpannableString(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) ? toSpannableString(str, ACTION_COLOR_NORMAL) : (SpannableString) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
    }

    public CharSequence toSpannableStringWithTopic(String str, int i3, int i16, ITopic.OnTopicClickListener onTopicClickListener) {
        String str2;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (CharSequence) iPatchRedirector.redirect((short) 18, this, str, Integer.valueOf(i3), Integer.valueOf(i16), onTopicClickListener);
        }
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
        h(spannableStringBuilder, this.actionText);
        h(spannableStringBuilder, this.dataText);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder.toString().trim());
        int length = spannableStringBuilder2.length();
        if (length > str2.length()) {
            spannableStringBuilder2.append(TokenParser.SP);
            i17 = length + 1;
        } else {
            i17 = length;
        }
        if (shouldShowAtHead()) {
            for (int i18 = 0; i18 < this.topics.size(); i18++) {
                if (!TextUtils.isEmpty(this.topics.get(i18).second)) {
                    int length2 = spannableStringBuilder2.length();
                    String str3 = this.topics.get(i18).second;
                    com.tencent.mobileqq.richstatus.topic.a aVar = new com.tencent.mobileqq.richstatus.topic.a(onTopicClickListener, c(e(), f()), new Pair(this.topics.get(i18).first, str3));
                    spannableStringBuilder2.append((CharSequence) str3);
                    spannableStringBuilder2.setSpan(aVar, length2, str3.length() + length2, 33);
                }
            }
        }
        if (this.plainText != null) {
            for (int i19 = 0; i19 < this.locationPosition; i19++) {
                h(spannableStringBuilder2, this.plainText.get(i19));
            }
            int size = this.plainText.size();
            for (int i26 = this.locationPosition; i26 < size; i26++) {
                h(spannableStringBuilder2, this.plainText.get(i26));
            }
        }
        if (shouldShowMixing()) {
            sortTopicPos();
            for (int i27 = 0; i27 < this.topicsPos.size(); i27++) {
                String topicStrById = getTopicStrById(this.topicsPos.get(i27).first.intValue());
                if (!TextUtils.isEmpty(topicStrById)) {
                    int intValue = this.topicsPos.get(i27).second.intValue() + i17;
                    if (intValue > spannableStringBuilder2.length()) {
                        break;
                    }
                    com.tencent.mobileqq.richstatus.topic.a aVar2 = new com.tencent.mobileqq.richstatus.topic.a(onTopicClickListener, c(e(), f()), new Pair(this.topicsPos.get(i27).first, topicStrById));
                    spannableStringBuilder2.insert(intValue, (CharSequence) topicStrById);
                    spannableStringBuilder2.setSpan(aVar2, intValue, topicStrById.length() + intValue, 33);
                }
            }
        }
        if (length > str2.length()) {
            spannableStringBuilder2.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(i3, i16), 0, length, 33);
        }
        return spannableStringBuilder2;
    }

    public CharSequence toSpannableStringWithoutAction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) ? toSpannableStringWithoutAction(null) : (CharSequence) iPatchRedirector.redirect((short) 14, (Object) this);
    }

    public void topicFromJson(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
            return;
        }
        this.topics.clear();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i3);
                    int optInt = jSONObject.optInt("id");
                    String optString = jSONObject.optString("topic");
                    if (!TextUtils.isEmpty(optString)) {
                        this.topics.add(new Pair<>(Integer.valueOf(optInt), optString));
                    }
                }
            } catch (JSONException e16) {
                if (QLog.isDebugVersion()) {
                    QLog.i("RichStatus", 2, "topicFromJson" + e16.getMessage(), e16);
                }
            } catch (Exception e17) {
                if (QLog.isDebugVersion()) {
                    QLog.i("RichStatus", 2, "topicFromJson" + e17.getMessage(), e17);
                }
            }
        }
        if (QLog.isDebugVersion()) {
            QLog.i("RichStatus", 2, String.format("topicFromJson %s", str));
        }
    }

    public void topicPosFromJson(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) str);
            return;
        }
        this.topicsPos.clear();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i3);
                    this.topicsPos.add(new Pair<>(Integer.valueOf(jSONObject.optInt("id")), Integer.valueOf(jSONObject.optInt("topicPos"))));
                }
            } catch (JSONException e16) {
                if (QLog.isDebugVersion()) {
                    QLog.i("RichStatus", 2, "topicPosFromJson" + e16.getMessage(), e16);
                }
            } catch (Exception e17) {
                if (QLog.isDebugVersion()) {
                    QLog.i("RichStatus", 2, "topicPosFromJson" + e17.getMessage(), e17);
                }
            }
        }
        if (QLog.isDebugVersion()) {
            QLog.i("RichStatus", 2, String.format("topicPosFromJson %s", str));
        }
    }

    public String topicPosToJson() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (String) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        JSONArray jSONArray = null;
        for (int i3 = 0; i3 < this.topicsPos.size(); i3++) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", this.topicsPos.get(i3).first);
                jSONObject.put("topicPos", this.topicsPos.get(i3).second);
                if (jSONArray == null) {
                    jSONArray = new JSONArray();
                }
                jSONArray.mo162put(jSONObject);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        if (jSONArray != null) {
            str = jSONArray.toString();
        } else {
            str = "";
        }
        if (QLog.isDebugVersion()) {
            QLog.i("RichStatus", 2, String.format("topicPosToJson %s", str));
        }
        return str;
    }

    public String topicToJson() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        JSONArray jSONArray = null;
        for (int i3 = 0; i3 < this.topics.size(); i3++) {
            if (!TextUtils.isEmpty(this.topics.get(i3).second)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", this.topics.get(i3).first);
                    jSONObject.put("topic", this.topics.get(i3).second);
                    if (jSONArray == null) {
                        jSONArray = new JSONArray();
                    }
                    jSONArray.mo162put(jSONObject);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        }
        if (jSONArray != null) {
            str = jSONArray.toString();
        } else {
            str = "";
        }
        if (QLog.isDebugVersion()) {
            QLog.i("RichStatus", 2, String.format("topicToJson %s", str));
        }
        return str;
    }

    public String topicToPlainText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < this.topics.size(); i3++) {
            if (!TextUtils.isEmpty(this.topics.get(i3).second)) {
                sb5.append(this.topics.get(i3).second);
            }
        }
        if (QLog.isDebugVersion()) {
            QLog.i("RichStatus", 2, String.format("topicToPlainText %s", sb5.toString()));
        }
        return sb5.toString();
    }

    public CharSequence getLocSS(TextView textView, CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? getLocSS(textView.getResources(), textView.getTextSize(), charSequence) : (CharSequence) iPatchRedirector.redirect((short) 9, (Object) this, (Object) textView, (Object) charSequence);
    }

    public SpannableString toSpannableString(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) ? toSpannableString(str, i3, ACTION_COLOR_PRESSED) : (SpannableString) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, i3);
    }

    @NonNull
    public CharSequence toSpannableStringWithoutAction(ITopic.OnTopicClickListener onTopicClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (CharSequence) iPatchRedirector.redirect((short) 15, (Object) this, (Object) onTopicClickListener);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (shouldShowAtHead()) {
            for (int i3 = 0; i3 < this.topics.size(); i3++) {
                if (!TextUtils.isEmpty(this.topics.get(i3).second)) {
                    int length = spannableStringBuilder.length();
                    String str = this.topics.get(i3).second;
                    Object aVar = new com.tencent.mobileqq.richstatus.topic.a(onTopicClickListener, c(e(), f()), new Pair(this.topics.get(i3).first, str));
                    spannableStringBuilder.append((CharSequence) str);
                    spannableStringBuilder.setSpan(aVar, length, str.length() + length, 33);
                }
            }
        }
        if (this.plainText != null) {
            for (int i16 = 0; i16 < this.locationPosition; i16++) {
                h(spannableStringBuilder, this.plainText.get(i16));
            }
            int size = this.plainText.size();
            for (int i17 = this.locationPosition; i17 < size; i17++) {
                h(spannableStringBuilder, this.plainText.get(i17));
            }
        }
        if (shouldShowMixing()) {
            sortTopicPos();
            for (int i18 = 0; i18 < this.topicsPos.size(); i18++) {
                String topicStrById = getTopicStrById(this.topicsPos.get(i18).first.intValue());
                if (!TextUtils.isEmpty(topicStrById)) {
                    int intValue = this.topicsPos.get(i18).second.intValue();
                    if (intValue > spannableStringBuilder.length()) {
                        break;
                    }
                    Object aVar2 = new com.tencent.mobileqq.richstatus.topic.a(onTopicClickListener, c(e(), f()), new Pair(this.topicsPos.get(i18).first, topicStrById));
                    spannableStringBuilder.insert(intValue, (CharSequence) topicStrById);
                    spannableStringBuilder.setSpan(aVar2, intValue, topicStrById.length() + intValue, 33);
                }
            }
        }
        return spannableStringBuilder;
    }

    public CharSequence getLocSS(Resources resources, float f16, CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (CharSequence) iPatchRedirector.redirect((short) 10, this, resources, Float.valueOf(f16), charSequence);
        }
        if (TextUtils.isEmpty(this.locationText)) {
            return charSequence;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append((Object) (charSequence != null ? charSequence : ""));
        sb5.append(LOC_SPAN_PLACE_HOLDER);
        sb5.append(" ");
        sb5.append(this.locationText);
        SpannableString spannableString = new SpannableString(sb5.toString());
        try {
            Bitmap decodeResource = BitmapFactory.decodeResource(resources, com.tencent.mobileqq.R.drawable.bwm);
            if (decodeResource == null) {
                return charSequence;
            }
            int i3 = (int) ((f16 * 0.9f) + 0.5f);
            int width = (decodeResource.getWidth() * i3) / decodeResource.getHeight();
            bo boVar = new bo(resources, decodeResource, false, true);
            boVar.setBounds(0, 0, width, i3);
            OffsetableImageSpan offset = new OffsetableImageSpan(boVar, 0).setOffset(-0.1f);
            int length = charSequence != null ? charSequence.length() : 0;
            spannableString.setSpan(offset, length, length + 3, 33);
            return spannableString;
        } catch (OutOfMemoryError unused) {
            return charSequence;
        }
    }

    public SpannableString toSpannableString(String str, int i3, int i16) {
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (SpannableString) iPatchRedirector.redirect((short) 13, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        if (str == null) {
            str = "";
        }
        StringBuilder sb5 = new StringBuilder(str);
        i(sb5, this.actionText);
        i(sb5, this.dataText);
        StringBuilder sb6 = new StringBuilder(sb5.toString().trim());
        int length = sb6.length();
        if (length > str.length()) {
            sb6.append(TokenParser.SP);
            i17 = length + 1;
        } else {
            i17 = length;
        }
        if (shouldShowAtHead()) {
            for (int i18 = 0; i18 < this.topics.size(); i18++) {
                sb6.append(this.topics.get(i18).second);
            }
        }
        if (this.plainText != null) {
            for (int i19 = 0; i19 < this.locationPosition; i19++) {
                i(sb6, this.plainText.get(i19));
            }
            int size = this.plainText.size();
            for (int i26 = this.locationPosition; i26 < size; i26++) {
                i(sb6, this.plainText.get(i26));
            }
        }
        if (shouldShowMixing()) {
            sortTopicPos();
            for (int i27 = 0; i27 < this.topicsPos.size(); i27++) {
                String topicStrById = getTopicStrById(this.topicsPos.get(i27).first.intValue());
                if (!TextUtils.isEmpty(topicStrById)) {
                    int intValue = this.topicsPos.get(i27).second.intValue() + i17;
                    if (intValue > sb6.length()) {
                        break;
                    }
                    sb6.insert(intValue, topicStrById);
                }
            }
        }
        SpannableString spannableString = new SpannableString(sb6.toString().trim());
        if (length > str.length()) {
            spannableString.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(i3, i16), 0, length, 33);
        }
        return spannableString;
    }
}
