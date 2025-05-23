package com.tencent.mobileqq.dt.api;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.mini.sdk.JsonORM;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class JubaoMsgData implements Serializable {
    static IPatchRedirector $redirector_;

    @JsonORM.Column(key = "channelUin")
    public String channelUin;

    @JsonORM.Column(key = "msgID")
    public long msgID;

    @JsonORM.Column(key = "msgRandom")
    public int msgRandom;

    @JsonORM.Column(key = "msgSeq")
    public int msgSeq;

    @JsonORM.Column(key = "msgTime")
    public int msgTime;

    @JsonORM.Column(key = "result")
    public int result;

    public JubaoMsgData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public JSONObject toJson() throws JsonORM.JsonParseException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (JSONObject) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return JsonORM.toJSON(this);
    }

    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "JubaoMsgData{msgSeq=" + this.msgSeq + ", msgTime=" + this.msgTime + ", msgRandom=" + this.msgRandom + ", result=" + this.result + ", channelUin='" + this.channelUin + "'}";
    }
}
