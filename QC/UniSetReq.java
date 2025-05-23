package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UniSetReq extends JceStruct {
    static Map<String, String> cache_ext_map;
    static String cache_operationid;
    static Concise cache_stConcise;
    static ExtendFriend cache_stExtendFriend;
    static Font cache_stFont;
    static GroupEffect cache_stGroupEffect;
    static NamePlate cache_stNamePlate;
    static Nudge cache_stNudge;
    static Signature cache_stSignature;
    static SummaryCard cache_stSummaryCard;
    public int clearflag;
    public Map<String, String> ext_map;
    public String operationid;
    public Bubble stBubble;
    public Concise stConcise;
    public ExtendFriend stExtendFriend;
    public Font stFont;
    public Funcall stFuncall;
    public GroupEffect stGroupEffect;
    public Hamlet stHamletItem;
    public ArrayList<Hamlet> stHamletItemList;
    public LoginInfo stLogin;
    public MessageShow stMessageShow;
    public NamePlate stNamePlate;
    public Nudge stNudge;
    public Redpacket stRedpacket;
    public Signature stSignature;
    public SummaryCard stSummaryCard;
    public UniBusinessItem stUniBusinessItem;
    static LoginInfo cache_stLogin = new LoginInfo();
    static UniBusinessItem cache_stUniBusinessItem = new UniBusinessItem();
    static Hamlet cache_stHamletItem = new Hamlet();
    static Bubble cache_stBubble = new Bubble();
    static Redpacket cache_stRedpacket = new Redpacket();
    static Funcall cache_stFuncall = new Funcall();
    static MessageShow cache_stMessageShow = new MessageShow();
    static ArrayList<Hamlet> cache_stHamletItemList = new ArrayList<>();

    static {
        cache_stHamletItemList.add(new Hamlet());
        cache_stGroupEffect = new GroupEffect();
        HashMap hashMap = new HashMap();
        cache_ext_map = hashMap;
        hashMap.put("", "");
        cache_stSummaryCard = new SummaryCard();
        cache_stSignature = new Signature();
        cache_stNamePlate = new NamePlate();
        cache_stExtendFriend = new ExtendFriend();
        cache_stFont = new Font();
        cache_stConcise = new Concise();
        cache_stNudge = new Nudge();
        cache_operationid = new String();
    }

    public UniSetReq() {
        this.stLogin = null;
        this.stUniBusinessItem = null;
        this.stHamletItem = null;
        this.stBubble = null;
        this.stRedpacket = null;
        this.stFuncall = null;
        this.stMessageShow = null;
        this.stHamletItemList = null;
        this.clearflag = 0;
        this.stGroupEffect = null;
        this.ext_map = null;
        this.stSummaryCard = null;
        this.stSignature = null;
        this.stNamePlate = null;
        this.stExtendFriend = null;
        this.stFont = null;
        this.stConcise = null;
        this.stNudge = null;
        this.operationid = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stLogin = (LoginInfo) jceInputStream.read((JceStruct) cache_stLogin, 0, true);
        this.stUniBusinessItem = (UniBusinessItem) jceInputStream.read((JceStruct) cache_stUniBusinessItem, 1, false);
        this.stHamletItem = (Hamlet) jceInputStream.read((JceStruct) cache_stHamletItem, 2, false);
        this.stBubble = (Bubble) jceInputStream.read((JceStruct) cache_stBubble, 3, false);
        this.stRedpacket = (Redpacket) jceInputStream.read((JceStruct) cache_stRedpacket, 4, false);
        this.stFuncall = (Funcall) jceInputStream.read((JceStruct) cache_stFuncall, 5, false);
        this.stMessageShow = (MessageShow) jceInputStream.read((JceStruct) cache_stMessageShow, 6, false);
        this.stHamletItemList = (ArrayList) jceInputStream.read((JceInputStream) cache_stHamletItemList, 7, false);
        this.clearflag = jceInputStream.read(this.clearflag, 8, false);
        this.stGroupEffect = (GroupEffect) jceInputStream.read((JceStruct) cache_stGroupEffect, 9, false);
        this.ext_map = (Map) jceInputStream.read((JceInputStream) cache_ext_map, 10, false);
        this.stSummaryCard = (SummaryCard) jceInputStream.read((JceStruct) cache_stSummaryCard, 11, false);
        this.stSignature = (Signature) jceInputStream.read((JceStruct) cache_stSignature, 12, false);
        this.stNamePlate = (NamePlate) jceInputStream.read((JceStruct) cache_stNamePlate, 13, false);
        this.stExtendFriend = (ExtendFriend) jceInputStream.read((JceStruct) cache_stExtendFriend, 14, false);
        this.stFont = (Font) jceInputStream.read((JceStruct) cache_stFont, 15, false);
        this.stConcise = (Concise) jceInputStream.read((JceStruct) cache_stConcise, 16, false);
        this.stNudge = (Nudge) jceInputStream.read((JceStruct) cache_stNudge, 17, false);
        this.operationid = jceInputStream.read(cache_operationid, 18, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stLogin, 0);
        UniBusinessItem uniBusinessItem = this.stUniBusinessItem;
        if (uniBusinessItem != null) {
            jceOutputStream.write((JceStruct) uniBusinessItem, 1);
        }
        Hamlet hamlet = this.stHamletItem;
        if (hamlet != null) {
            jceOutputStream.write((JceStruct) hamlet, 2);
        }
        Bubble bubble = this.stBubble;
        if (bubble != null) {
            jceOutputStream.write((JceStruct) bubble, 3);
        }
        Redpacket redpacket = this.stRedpacket;
        if (redpacket != null) {
            jceOutputStream.write((JceStruct) redpacket, 4);
        }
        Funcall funcall = this.stFuncall;
        if (funcall != null) {
            jceOutputStream.write((JceStruct) funcall, 5);
        }
        MessageShow messageShow = this.stMessageShow;
        if (messageShow != null) {
            jceOutputStream.write((JceStruct) messageShow, 6);
        }
        ArrayList<Hamlet> arrayList = this.stHamletItemList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 7);
        }
        jceOutputStream.write(this.clearflag, 8);
        GroupEffect groupEffect = this.stGroupEffect;
        if (groupEffect != null) {
            jceOutputStream.write((JceStruct) groupEffect, 9);
        }
        Map<String, String> map = this.ext_map;
        if (map != null) {
            jceOutputStream.write((Map) map, 10);
        }
        SummaryCard summaryCard = this.stSummaryCard;
        if (summaryCard != null) {
            jceOutputStream.write((JceStruct) summaryCard, 11);
        }
        Signature signature = this.stSignature;
        if (signature != null) {
            jceOutputStream.write((JceStruct) signature, 12);
        }
        NamePlate namePlate = this.stNamePlate;
        if (namePlate != null) {
            jceOutputStream.write((JceStruct) namePlate, 13);
        }
        ExtendFriend extendFriend = this.stExtendFriend;
        if (extendFriend != null) {
            jceOutputStream.write((JceStruct) extendFriend, 14);
        }
        Font font = this.stFont;
        if (font != null) {
            jceOutputStream.write((JceStruct) font, 15);
        }
        Concise concise = this.stConcise;
        if (concise != null) {
            jceOutputStream.write((JceStruct) concise, 16);
        }
        Nudge nudge = this.stNudge;
        if (nudge != null) {
            jceOutputStream.write((JceStruct) nudge, 17);
        }
        String str = this.operationid;
        if (str != null) {
            jceOutputStream.write(str, 18);
        }
    }

    public UniSetReq(LoginInfo loginInfo, UniBusinessItem uniBusinessItem, Hamlet hamlet, Bubble bubble, Redpacket redpacket, Funcall funcall, MessageShow messageShow, ArrayList<Hamlet> arrayList, int i3, GroupEffect groupEffect, Map<String, String> map, SummaryCard summaryCard, Signature signature, NamePlate namePlate, ExtendFriend extendFriend, Font font, Concise concise, Nudge nudge, String str) {
        this.stLogin = loginInfo;
        this.stUniBusinessItem = uniBusinessItem;
        this.stHamletItem = hamlet;
        this.stBubble = bubble;
        this.stRedpacket = redpacket;
        this.stFuncall = funcall;
        this.stMessageShow = messageShow;
        this.stHamletItemList = arrayList;
        this.clearflag = i3;
        this.stGroupEffect = groupEffect;
        this.ext_map = map;
        this.stSummaryCard = summaryCard;
        this.stSignature = signature;
        this.stNamePlate = namePlate;
        this.stExtendFriend = extendFriend;
        this.stFont = font;
        this.stConcise = concise;
        this.stNudge = nudge;
        this.operationid = str;
    }
}
