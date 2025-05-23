package com.tencent.pts.ui;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.pts.utils.PTSConstant;
import com.tencent.pts.utils.PTSLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes22.dex */
public class PTSNodeInfo {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "PTSNodeInfo";
    private PTSNodeAttribute attributes;
    private List<PTSNodeInfo> children;
    private String content;
    private HashMap<String, String> eventInfo;
    private boolean isRootNode;
    private String nodeType;
    private String parentID;
    private PTSNodeStyle style;
    private String uniqueID;

    /* loaded from: classes22.dex */
    public static class Builder {
        static IPatchRedirector $redirector_;
        private PTSNodeAttribute attributes;
        private List<PTSNodeInfo> children;
        private String content;
        private HashMap<String, String> eventInfo;
        private boolean isRootNode;
        private String nodeType;
        private String parentID;
        private PTSNodeStyle style;
        private String uniqueID;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.style = new PTSNodeStyle();
            this.attributes = new PTSNodeAttribute();
            this.eventInfo = new HashMap<>();
        }

        private void check(PTSNodeInfo pTSNodeInfo) {
            if (pTSNodeInfo.style == null) {
                pTSNodeInfo.style = new PTSNodeStyle();
            }
            if (pTSNodeInfo.attributes == null) {
                pTSNodeInfo.attributes = new PTSNodeAttribute();
            }
            if (pTSNodeInfo.eventInfo == null) {
                pTSNodeInfo.eventInfo = new HashMap();
            }
        }

        public PTSNodeInfo build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (PTSNodeInfo) iPatchRedirector.redirect((short) 13, (Object) this);
            }
            if (TextUtils.isEmpty(this.nodeType)) {
                PTSLog.e(PTSNodeInfo.TAG, "[build] PTSNodeInfo is not valid, nodeType is empty.");
                if (!PTSLog.isDebug()) {
                    this.nodeType = "view";
                } else {
                    throw new IllegalArgumentException("[build] PTSNodeInfo is not valid, nodeType is empty.");
                }
            }
            if (TextUtils.isEmpty(this.uniqueID)) {
                PTSLog.e(PTSNodeInfo.TAG, "[build] PTSNodeInfo is not valid, id is empty.");
                if (!PTSLog.isDebug()) {
                    this.uniqueID = "pts_uid_" + System.currentTimeMillis();
                } else {
                    throw new IllegalArgumentException("[build] PTSNodeInfo is not valid, id is empty.");
                }
            }
            PTSNodeInfo pTSNodeInfo = new PTSNodeInfo(null);
            pTSNodeInfo.nodeType = this.nodeType;
            pTSNodeInfo.uniqueID = this.uniqueID;
            pTSNodeInfo.isRootNode = this.isRootNode;
            pTSNodeInfo.parentID = this.parentID;
            pTSNodeInfo.content = this.content;
            pTSNodeInfo.style = this.style;
            pTSNodeInfo.attributes = this.attributes;
            pTSNodeInfo.children = this.children;
            pTSNodeInfo.eventInfo = this.eventInfo;
            check(pTSNodeInfo);
            return pTSNodeInfo;
        }

        public Builder withChildren(List<PTSNodeInfo> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (Builder) iPatchRedirector.redirect((short) 12, (Object) this, (Object) list);
            }
            this.children = list;
            return this;
        }

        public Builder withContent(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            }
            this.content = str;
            return this;
        }

        public Builder withEventInfo(HashMap<String, String> hashMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (Builder) iPatchRedirector.redirect((short) 11, (Object) this, (Object) hashMap);
            }
            this.eventInfo = hashMap;
            return this;
        }

        public Builder withIsRootNode(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, z16);
            }
            this.isRootNode = z16;
            return this;
        }

        public Builder withNodeType(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            this.nodeType = str;
            return this;
        }

        public Builder withPTSAttribute(PTSNodeAttribute pTSNodeAttribute) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Builder) iPatchRedirector.redirect((short) 9, (Object) this, (Object) pTSNodeAttribute);
            }
            this.attributes = new PTSNodeAttribute(pTSNodeAttribute);
            return this;
        }

        public Builder withPTSStyle(PTSNodeStyle pTSNodeStyle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) pTSNodeStyle);
            }
            this.style = new PTSNodeStyle(pTSNodeStyle);
            return this;
        }

        public Builder withParentID(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            }
            this.parentID = str;
            return this;
        }

        public Builder withUniqueID(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            this.uniqueID = str;
            return this;
        }

        public Builder withPTSAttribute(JSONObject jSONObject) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Builder) iPatchRedirector.redirect((short) 10, (Object) this, (Object) jSONObject);
            }
            this.attributes = new PTSNodeAttribute(jSONObject);
            return this;
        }

        public Builder withPTSStyle(JSONObject jSONObject) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Builder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) jSONObject);
            }
            this.style = new PTSNodeStyle(jSONObject);
            return this;
        }
    }

    /* synthetic */ PTSNodeInfo(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) {
            return;
        }
        iPatchRedirector.redirect((short) 22, (Object) this, (Object) anonymousClass1);
    }

    public void addChild(PTSNodeInfo pTSNodeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) pTSNodeInfo);
            return;
        }
        if (this.children == null) {
            this.children = new ArrayList();
        }
        this.children.add(pTSNodeInfo);
    }

    public void addChildren(List<PTSNodeInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) list);
        } else if (list != null && !list.isEmpty()) {
            if (this.children == null) {
                this.children = new ArrayList();
            }
            this.children.addAll(list);
        }
    }

    public boolean equals(@Nullable Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, obj)).booleanValue();
        }
        if (obj instanceof PTSNodeInfo) {
            return TextUtils.equals(this.uniqueID, ((PTSNodeInfo) obj).getUniqueID());
        }
        return false;
    }

    public PTSNodeAttribute getAttributes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (PTSNodeAttribute) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.attributes;
    }

    public int getChildCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        List<PTSNodeInfo> list = this.children;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<PTSNodeInfo> getChildren() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (List) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        if (this.children == null) {
            return new ArrayList();
        }
        return new ArrayList(this.children);
    }

    public String getContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.content;
    }

    public HashMap<String, String> getEventInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (HashMap) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.eventInfo;
    }

    public String getNodeType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.nodeType;
    }

    public String getParentID() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.parentID;
    }

    public PTSNodeStyle getStyle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (PTSNodeStyle) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.style;
    }

    public String getUniqueID() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.uniqueID;
    }

    public boolean hasChildren() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        List<PTSNodeInfo> list = this.children;
        if (list != null && list.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean hasParent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return !TextUtils.isEmpty(this.parentID);
    }

    public boolean isContainer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        if (!"view".equals(this.nodeType) && !"page".equals(this.nodeType) && !"block".equals(this.nodeType) && !PTSConstant.VNT_SWIPER_ITEM.equals(this.nodeType)) {
            return false;
        }
        return true;
    }

    public boolean isRootNode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.isRootNode;
    }

    public void removeChild(PTSNodeInfo pTSNodeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) pTSNodeInfo);
            return;
        }
        List<PTSNodeInfo> list = this.children;
        if (list != null) {
            list.remove(pTSNodeInfo);
        }
    }

    public void setChild(int i3, PTSNodeInfo pTSNodeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3, (Object) pTSNodeInfo);
            return;
        }
        List<PTSNodeInfo> list = this.children;
        if (list != null && i3 >= 0 && i3 < list.size()) {
            this.children.set(i3, pTSNodeInfo);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("PTSNodeInfo: \n");
        sb5.append("uniqueID: ");
        sb5.append(this.uniqueID);
        sb5.append("\n");
        sb5.append("nodeType: ");
        sb5.append(this.nodeType);
        sb5.append("\n");
        sb5.append("isRootNode: ");
        sb5.append(this.isRootNode);
        sb5.append("\n");
        sb5.append("parentID: ");
        sb5.append(this.parentID);
        sb5.append("\n");
        sb5.append("content: ");
        sb5.append(this.content);
        sb5.append("\n");
        sb5.append("\n");
        sb5.append("Styles: ");
        sb5.append("\n");
        for (Map.Entry<String, Object> entry : this.style.entrySet()) {
            sb5.append("style [");
            sb5.append(entry.getKey());
            sb5.append("] = ");
            sb5.append(entry.getValue());
            sb5.append("\n");
        }
        sb5.append("\n");
        sb5.append("Attributes: ");
        sb5.append("\n");
        for (Map.Entry<String, Object> entry2 : this.attributes.entrySet()) {
            sb5.append("attribute [");
            sb5.append(entry2.getKey());
            sb5.append("] = ");
            sb5.append(entry2.getValue());
            sb5.append("\n");
        }
        sb5.append("\n");
        sb5.append("EventInfo: ");
        sb5.append("\n");
        for (Map.Entry<String, String> entry3 : this.eventInfo.entrySet()) {
            sb5.append("eventInfo [");
            sb5.append(entry3.getKey());
            sb5.append("] = ");
            sb5.append(entry3.getValue());
            sb5.append("\n");
        }
        if (hasChildren()) {
            sb5.append("\n");
            sb5.append("child count = ");
            sb5.append(getChildCount());
            sb5.append("\n");
            sb5.append("\n");
            sb5.append("Children: ");
            sb5.append("\n");
            List<PTSNodeInfo> children = getChildren();
            for (int i3 = 0; i3 < children.size(); i3++) {
                sb5.append("child [");
                sb5.append(i3);
                sb5.append("] = \n");
                sb5.append(children.get(i3));
                sb5.append("\n");
            }
        }
        return sb5.toString();
    }

    PTSNodeInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public void addChild(int i3, PTSNodeInfo pTSNodeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3, (Object) pTSNodeInfo);
            return;
        }
        if (this.children == null) {
            this.children = new ArrayList();
        }
        if (i3 >= 0 && i3 < this.children.size()) {
            this.children.add(i3, pTSNodeInfo);
        } else {
            this.children.add(pTSNodeInfo);
        }
    }
}
