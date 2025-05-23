package com.tencent.qqnt.graytips.decoder.xml;

import com.tencent.autotemplate.extra.PreDetect;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes24.dex */
public class UniteEntity implements Serializable {
    static IPatchRedirector $redirector_;
    Note mRootNote;

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static class Note implements Serializable {
        static IPatchRedirector $redirector_;
        HashMap<Integer, Object> fields;
        Note mParent;
        ArrayList<Note> mSubNotes;
        int noteType;

        public Note(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
                return;
            }
            this.noteType = i3;
            this.fields = new HashMap<>();
            this.mSubNotes = new ArrayList<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String b(int i3) {
            StringBuilder sb5 = new StringBuilder();
            StringBuilder sb6 = new StringBuilder();
            for (int i16 = 0; i16 < i3; i16++) {
                sb6.append("\t");
            }
            sb5.append((CharSequence) sb6);
            sb5.append(UniteEntity.getNoteTypeName(this.noteType));
            sb5.append(":[\n");
            sb5.append((CharSequence) sb6);
            sb5.append("\tfields");
            sb5.append(":[\n");
            for (Integer num : this.fields.keySet()) {
                String fieldTypeName = UniteEntity.getFieldTypeName(num.intValue());
                Object obj = this.fields.get(num);
                sb5.append((CharSequence) sb6);
                sb5.append("\t\t");
                sb5.append(fieldTypeName);
                sb5.append(":");
                sb5.append(obj);
                sb5.append("\n");
            }
            sb5.append((CharSequence) sb6);
            sb5.append("\t]");
            sb5.append("\n");
            int i17 = i3 + 1;
            Iterator<Note> it = this.mSubNotes.iterator();
            while (it.hasNext()) {
                sb5.append(it.next().b(i17));
            }
            sb5.append((CharSequence) sb6);
            sb5.append("]");
            sb5.append("\n");
            return sb5.toString();
        }

        public void addField(int i3, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, obj);
            } else {
                this.fields.put(Integer.valueOf(i3), obj);
            }
        }

        public void addSubNote(Note note) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) note);
            } else {
                this.mSubNotes.add(note);
            }
        }

        public HashMap<Integer, Object> getFields() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (HashMap) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.fields;
        }

        public int getNoteType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return this.noteType;
        }

        public Note getParent() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Note) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.mParent;
        }

        public ArrayList<Note> getSubNotes() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (ArrayList) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return this.mSubNotes;
        }

        public boolean isNorText() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
            }
            if (this.noteType == 2) {
                return true;
            }
            return false;
        }

        public Note setParent(Note note) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Note) iPatchRedirector.redirect((short) 6, (Object) this, (Object) note);
            }
            this.mParent = note;
            note.addSubNote(this);
            return this;
        }
    }

    public UniteEntity(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.mRootNote = new Note(i3);
        }
    }

    public static String getFieldTypeName(int i3) {
        switch (i3) {
            case 1:
                return "align";
            case 2:
                return "text";
            case 3:
                return "size";
            case 4:
                return "jump";
            case 5:
                return "color";
            case 6:
                return "uin";
            case 7:
                return "name";
            case 8:
                return "src";
            case 9:
                return "type";
            case 10:
                return QCircleSchemeAttr.Polymerize.ALT;
            case 11:
                return "status";
            case 12:
                return "ex_status";
            case 13:
                return "battery_status";
            case 14:
                return "openid";
            case 15:
                return "ext_uin";
            case 16:
                return AppConstants.Key.COLUMN_MSG_SEQ;
            case 17:
                return "face_id";
            case 18:
                return "face_type";
            default:
                return "";
        }
    }

    public static String getNoteTypeName(int i3) {
        switch (i3) {
            case 1:
                return "graytip";
            case 2:
                return "nor_text";
            case 3:
                return "url";
            case 4:
                return "qq";
            case 5:
                return "img";
            case 6:
                return "dialog";
            case 7:
                return "title";
            case 8:
                return "alter";
            case 9:
                return "btn";
            case 10:
                return PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME;
            case 11:
                return "olstatus";
            case 12:
                return PreDetect.FACE_DETECT;
            default:
                return "";
        }
    }

    public Note getRootNote() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Note) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.mRootNote;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return this.mRootNote.b(0);
        }
        return (String) iPatchRedirector.redirect((short) 3, (Object) this);
    }
}
