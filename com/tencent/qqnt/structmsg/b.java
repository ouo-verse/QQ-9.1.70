package com.tencent.qqnt.structmsg;

import NS_COMM.COMM;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.Comm_errKt;
import com.tencent.imsdk.BaseConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tav.decoder.EncoderWriter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.regex.Pattern;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f362292a;

    /* renamed from: b, reason: collision with root package name */
    private static final SparseIntArray f362293b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65977);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        int[] iArr = {128522, 128524, 128538, 128531, 128560, 128541, 128513, 128540, 9786, 128521, 128525, 128532, 128516, 128527, 128530, 128563, 128536, 128557, 128561, 128514, 128170, 128074, 128077, 9757, 128079, 9996, 128078, 128591, 128076, 128072, 128073, 128070, 128071, 128064, 128067, 128068, 128066, 127834, 127837, 127836, 127833, 127847, 127843, 127874, 127838, 127828, 127859, 127839, 127866, 127867, 127864, 9749, 127822, 127818, 127827, 127817, 128138, 128684, 127876, 127801, 127881, 127796, 128157, 127872, 127880, 128026, 128141, 128163, 128081, 128276, 11088, 10024, 128168, 128166, 128293, 127942, 128176, 128164, 9889, 128099, 128169, 128137, 9832, 128235, 128273, 128274, 9992, 128644, 128663, 128676, 128690, 128014, 128640, 128652, 9973, 128105, 128104, 128103, 128102, 128053, 128025, 128055, 128128, 128036, 128040, 128046, 128020, 128056, 128123, 128027, 128032, 128054, 128047, 128124, 128039, 128051, 128045, 128082, 128087, 128132, 128096, 128098, 127746, 128092, 128089, 128085, 128095, 9729, 9728, 9748, 127769, 9924, 11093, 10060, 10068, 10069, 9742, 128247, 128241, 128224, 128187, 127909, 127908, 128299, 128191, 128147, 9827, 126980, 12349, 127920, 128677, 128679, 127928, 128136, 128704, 128701, 127968, 9962, 127974, 127973, 127976, 127975, 127978, 128697, 128698, 169, 174, 8482, 9786, 9888, 9917, 9925, 9978, 9989, 9994, 9995, 10052, 12951, 127383, 127804, 127808, 127812, 127815, 127820, 127821, 127824, 127846, 127853, 127868, 127918, 127923, 127925, 127929, 127931, 127934, 127936, 127946, 128009, 128013, 128044, 128126, 128127, 128148, 128162, 128175, 128552, 128201, 128205, 128222, 128512, 128545, 128515, 128516, 128517, 128518, 128519, 128520, 128522, 128523, 128525, 128526, 128528, 128529, 128531, 128533, 128535, 128537, 128539, 128542, 128543, 128544, 128547, 128548, 128550, 128551, 128553, 128554, 128555, 128556, 128558, 128559, 128562, 128565, 128566, 128567, 128534, 128549, 128546, 128114, 128115, 128110, 128119, 128130, 128118, 128116, 128117, 128113, 128120, 128570, 128568, 128571, 128573, 128572, 128576, 128575, 128569, 128574, 128121, 128122, 128584, 128585, 128586, 128125, 127775, 128171, 128165, 128167, 128069, 128075, 128080, 128588, 128694, 127939, 128131, 128107, 128106, 128108, 128109, 128143, 128145, 128111, 128582, 128581, 128129, 128587, 128134, 128135, 128133, 128112, 128590, 128589, 128583, 127913, 128094, 128097, 128084, 128090, 127933, 128086, 128088, 128188, 128093, 128091, 128083, 128155, 128153, 128156, 128154, 10084, 128151, 128149, 128150, 128158, 128152, 128140, 128139, 128142, 128100, 128101, 128172, 128173, 128058, 128049, 128057, 128048, 128059, 128061, 128023, 128018, 128052, 128017, 128024, 128060, 128038, 128037, 128035, 128034, 128029, 128028, 128030, 128012, 128031, 128011, 128004, 128015, EncoderWriter.OUTPUT_AUDIO_BIT_RATE, 128003, 128005, 128007, 128016, 128019, 128021, 128022, 128001, 128002, 128050, 128033, 128010, 128043, 128042, 128006, 128008, 128041, 128062, 128144, 127800, 127799, 127803, 127802, 127809, 127811, 127810, 127807, 127806, 127797, 127794, 127795, 127792, 127793, 127760, 127774, 127773, 127770, 127761, 127762, 127763, 127764, 127765, 127766, 127767, 127768, 127772, 127771, 127757, 127758, 127759, 127755, 127756, 127776, 127744, 127745, 127752, 127754, 127885, 127886, 127890, 127891, 127887, 127878, 127879, 127888, 127889, 127875, 127877, 127873, 127883, 127882, 127884, 128302, 128249, 128252, 128192, 128189, 128190, 128223, 128225, 128250, 128251, 128266, 128265, 128264, 128263, 128277, 128226, 128227, FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_DOWNLOAD_PIC_FAIL, 8987, 9200, 8986, 128275, 128271, 128272, 128270, 128161, 128294, 128262, 128261, 128268, 128267, 128269, 128705, 128703, 128295, 128297, 128296, 128682, 128298, 128180, 128181, 128183, 128182, 128179, 128184, 128242, 128231, 128229, 128228, 9993, 128233, 128232, 128239, 128234, 128236, 128237, 128238, 128230, 128221, 128196, 128195, 128209, 128202, 128220, 128203, 128197, 128198, 128199, 128193, 128194, 9986, 128204, 128206, 10002, 9999, 128207, 128208, 128213, 128215, 128216, 128217, 128211, 128212, 128210, 128218, 128214, 128278, 128219, 128300, 128301, 128240, 127911, 127932, 127926, 127930, 127927, 127183, 127924, 127922, 127919, 127944, 9918, 127921, 127945, 9971, 128693, 128692, 127937, 127943, 127935, 127938, 127940, 127907, 127861, 127862, 127865, 127863, 127860, 127829, 127831, 127830, 127835, 127844, 127857, 127845, 127832, 127858, 127842, 127841, 127849, 127854, 127848, 127856, 127850, 127851, 127852, 127855, 127823, 127819, 127826, 127825, 127816, 127840, 127814, 127813, 127805, 127969, 127979, 127970, 127971, 127977, 128146, 127980, 127972, 127751, 127750, 127983, 127984, 127981, 128508, 128510, 128507, 127748, 127749, 127747, 128509, 127753, 127904, 127905, 9970, 127906, 128674, 128675, 9875, 128186, 128641, 128642, 128650, 128649, 128670, 128646, 128645, 128648, 128647, 128669, 128651, 128643, 128654, 128653, 128665, 128664, 128661, 128662, 128667, 128666, 128680, 128660, 128656, 128673, 128671, 128672, 128668, 128655, 127915, 128678, 128304, 9981, 127982, 128511, 127914, 127917, 128681, 128287, 128290, 128291, 11014, 11015, 11013, 128288, 128289, 128292, 8599, 8598, 8600, 8601, 8596, 8597, 128260, 9664, AppConstants.VALUE.UIN_TYPE_DING_DONG_SCHEDULE, 128316, 128317, 8617, 8618, BaseConstants.ERR_SDK_GROUP_INVALID_FACE_URL, 9194, 9193, 9195, 9196, 10549, 10548, 128256, 128257, 128258, 127381, 127385, 127378, 127379, 127382, 128246, 127910, 127489, 127535, 127539, 127541, 127540, 127538, 127568, 127545, 127546, 127542, 127514, 128699, 128700, 128702, 128688, 128686, 127359, 9855, 128685, 127543, 127544, 127490, 9410, 128706, 128708, 128709, 128707, 127569, 12953, 127377, 127384, 127380, 128683, 128286, 128245, 128687, 128689, 128691, 128695, 128696, 9940, 10035, 10055, Comm_errKt.QZRetCode_QZ_IMS_SPACE_EXCEED_LIMIT, 10036, 128159, 127386, 128243, 128244, 127344, 127345, 127374, 127358, 128160, 10175, 9851, 9800, 9801, 9802, 9803, 9804, 9805, 9806, 9807, 9808, 9809, 9810, 9811, 9934, 128303, 128185, 128178, 128177, 8252, 8265, 10071, 10067, 128285, 128282, 128281, 128283, 128284, 128359, 128336, 128348, 128337, 128349, 128338, 128350, 128339, 128351, 128340, 128352, 128341, 128342, 128343, 128344, 128345, 128346, 128353, 128354, 128355, 128356, 128357, 128358, 10006, COMM.mini_base_userinfo, 10134, COMM.mini_base_auth, 9824, 9829, 9830, 128174, 10004, 9745, 128280, 128279, COMM.mini_base_appinfo, 12336, 128305, 9724, 9723, 9726, 9725, 9642, 9643, 128314, 128306, 128307, 9899, 9898, 128308, 128309, 128315, 11036, 11035, 128310, 128311, 128312, 128313, 128657, 128658, 128659};
        f362292a = iArr;
        f362293b = new SparseIntArray(iArr.length);
    }

    public static boolean a(String str, String str2, String str3) {
        int i3;
        int i16;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                String[] split = Pattern.compile(str3, 16).split(str);
                String[] split2 = Pattern.compile(str3, 16).split(str2);
                int max = Math.max(split.length, split2.length);
                for (int i17 = 0; i17 < max; i17++) {
                    if (split.length > i17) {
                        i3 = Integer.parseInt(split[i17]);
                    } else {
                        i3 = 0;
                    }
                    if (split2.length > i17) {
                        i16 = Integer.parseInt(split2[i17]);
                    } else {
                        i16 = 0;
                    }
                    if (i3 < i16) {
                        return false;
                    }
                }
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static a b(String str) {
        String uuid = UUID.randomUUID().toString();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(c(str).getBytes());
        d dVar = new d();
        dVar.c(uuid);
        dVar.b(false);
        try {
            SAXParserFactory.newInstance().newSAXParser().parse(byteArrayInputStream, dVar);
            byteArrayInputStream.close();
            a a16 = dVar.a();
            if (a16 != null && QLog.isDevelopLevel()) {
                QLog.d("StructMsgFactory", 4, "getStructMsgFromXmlBuff decode structmsg success");
            }
            return a16;
        } catch (IOException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("StructMsgFactory", 2, "getStructMsgFromXmlBuffByStream", e16);
                return null;
            }
            return null;
        } catch (ParserConfigurationException e17) {
            if (QLog.isColorLevel()) {
                QLog.e("StructMsgFactory", 2, "getStructMsgFromXmlBuffByStream", e17);
                return null;
            }
            return null;
        } catch (SAXException e18) {
            if (QLog.isColorLevel()) {
                QLog.e("StructMsgFactory", 2, "getStructMsgFromXmlBuffByStream", e18);
                return null;
            }
            return null;
        } catch (Exception e19) {
            if (QLog.isColorLevel()) {
                QLog.e("StructMsgFactory", 2, "getStructMsg", e19);
                return null;
            }
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String c(String str) {
        boolean a16;
        int i3;
        boolean z16;
        String property = System.getProperty("java.vm.version");
        if (!TextUtils.isEmpty(property)) {
            try {
                a16 = a(property, "2.0.0", ".");
            } catch (Exception unused) {
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("StructMsgFactory", 4, "java vm version  = " + property + " isART = " + a16);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            i3 = 0;
            int i16 = 0;
            while (i3 < str.length()) {
                char charAt = str.charAt(i3);
                if (charAt != '\t' && charAt != '\n' && charAt != '\r' && charAt != '&' && charAt != '<' && charAt != '>') {
                    if ((charAt >= ' ' && charAt <= '\ud7ff') || (charAt >= '\ue000' && charAt <= '\ufffd')) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (a16) {
                        if (!z16) {
                            sb5.deleteCharAt(i3 - i16);
                            i16++;
                            if (QLog.isColorLevel()) {
                                QLog.d("StructMsgFactory", 2, " ContainInvalidCharacter return null ,invalid char  = " + Integer.toHexString(charAt));
                            }
                        }
                    } else if (!z16) {
                        int codePointAt = str.codePointAt(i3);
                        if (f362293b.get(codePointAt, -1) >= 0) {
                            if (codePointAt > 65535) {
                                i3++;
                            }
                        } else {
                            sb5.deleteCharAt(i3 - i16);
                            i16++;
                        }
                    }
                }
                i3++;
            }
            return sb5.toString();
        }
        a16 = false;
        if (QLog.isDevelopLevel()) {
        }
        StringBuilder sb52 = new StringBuilder();
        sb52.append(str);
        i3 = 0;
        int i162 = 0;
        while (i3 < str.length()) {
        }
        return sb52.toString();
    }
}
